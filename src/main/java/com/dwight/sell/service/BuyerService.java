package com.dwight.sell.service;

import com.dwight.sell.dto.OrderDTO;

public interface BuyerService {
    //find one order
    OrderDTO findOrderOne(String openid, String orderId);

    //cancel order
    OrderDTO cancelOrder(String openid, String orderId);
}
