package com.dwight.sell.dto;


import com.dwight.sell.dataobject.OrderDetail;
import com.dwight.sell.enums.OrderStatusEnum;
import com.dwight.sell.enums.PayStatusEnum;
import com.dwight.sell.utils.EnumUtil;
import com.dwight.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    /*default as new order*/
    private Integer orderStatus;
    /*default as unpaid*/
    private Integer payStatus;
    @JsonSerialize(using= Date2LongSerializer.class)
    private Date creatTime;
    @JsonSerialize(using= Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
