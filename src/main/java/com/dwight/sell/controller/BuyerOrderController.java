package com.dwight.sell.controller;

import com.dwight.sell.VO.ResultVo;
import com.dwight.sell.converter.OrderForm2OrderDTOConverter;
import com.dwight.sell.dto.OrderDTO;
import com.dwight.sell.enums.ResultEnum;
import com.dwight.sell.exception.SellException;
import com.dwight.sell.form.OrderForm;
import com.dwight.sell.service.BuyerService;
import com.dwight.sell.service.OrderService;
import com.dwight.sell.utils.ResultVoUtil;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    /*create order*/
    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;
    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult=orderService.create(orderDTO);
        Map<String, String> map=new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVoUtil.success(map);
    }

    /*order list*/
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){

        if(StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request=new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage= orderService.findList(openid,request);
        return ResultVoUtil.success(orderDTOPage.getContent());

    }

    /*order detail*/
    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

        OrderDTO orderDTO=buyerService.findOrderOne(openid, orderId);
        return ResultVoUtil.success(orderDTO);
    }

    /*cancel order*/
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){

        buyerService.cancelOrder(openid,orderId);
        return ResultVoUtil.success();

    }
}
