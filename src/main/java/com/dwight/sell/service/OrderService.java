package com.dwight.sell.service;

import com.dwight.sell.dataobject.OrderMaster;
import com.dwight.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    /*create order*/
    OrderDTO create(OrderDTO orderDTO);

    /*find order*/
    OrderDTO findOne(String orderId);
    /*find orderlist*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /*cancel order*/
    OrderDTO cancel(OrderDTO orderDTO);
    /*finish order*/
    OrderDTO finish(OrderDTO orderDTO);
    /*pay order*/
    OrderDTO pay(OrderDTO orderDTO);

    Page<OrderDTO> findList(Pageable pageable);
}
