package com.dwight.sell.enums;

import lombok.Getter;
import org.aopalliance.reflect.Code;

@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0,"new order"),
    FINISHED(1,"finished order"),
    CANCELED(2,"canceled order");

    private Integer code;
    private String msg;
    OrderStatusEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

}
