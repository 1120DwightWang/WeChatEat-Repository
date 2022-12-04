package com.dwight.sell.controller;

import com.dwight.sell.dto.OrderDTO;
import com.dwight.sell.enums.ResultEnum;
import com.dwight.sell.exception.SellException;
import com.dwight.sell.service.OrderService;
import com.dwight.sell.service.impl.PayServiceImpl;
import com.lly835.bestpay.model.PayResponse;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayServiceImpl payService;
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        PayResponse payResponse=payService.create(orderDTO);
        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);
        return new ModelAndView("pay/create",map);
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestParam String notifyData){
        payService.notify(notifyData);
        return new ModelAndView("pay/success");
    }

}
