package com.dwight.sell.dataobject;

import com.dwight.sell.enums.OrderStatusEnum;
import com.dwight.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;

    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    /*default as new order*/
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    /*default as unpaid*/
    private Integer payStatus= PayStatusEnum.PAID.getCode();

    private Date creatTime;
    private Date updateTime;


}
