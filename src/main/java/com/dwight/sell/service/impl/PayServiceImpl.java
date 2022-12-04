package com.dwight.sell.service.impl;

import com.dwight.sell.dto.OrderDTO;
import com.dwight.sell.enums.ResultEnum;
import com.dwight.sell.exception.SellException;
import com.dwight.sell.service.OrderService;
import com.dwight.sell.service.PayService;
import com.dwight.sell.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.math.BigDecimal;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME="WeChat Food Order";
    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;
    @Override
    public PayResponse create(OrderDTO orderDTO){
        PayRequest payRequest=new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[Wechat Payment] startpayment request={}",payRequest);
        PayResponse payResponse=bestPayService.pay(payRequest);
        log.info("[Wechat Payment] startpayment response={}", payResponse);
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData){
        //1. verify certificate
        //2. pay status
        //3. pay amount
        //4. pay person(order person==pay person)
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("[wechat payment] async notice, payResponse={}", JsonUtil.toJson(notifyData));
        OrderDTO orderDTO=orderService.findOne(payResponse.getOrderId());
        if(orderDTO==null){
            log.error("[wechat payment] async notice, order not exist, orderId={}",payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(!MathUtil.equals(payResponse.getOrderAmount(),orderDTO.getOrderAmount().doubleValue())){
            log.error("[wechat payment] async notice, order amount doesn't fit, orderId={}," +
                    "微信通知金额={}, 系统金额={}",payResponse.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        orderService.pay(orderDTO);
        return payResponse;
    }

}
