package com.dwight.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum implements CodeEnum{

    UNPAID(0,"unpaid"),
    PAID(1,"paid");
    private Integer code;
    private String msg;
    PayStatusEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
