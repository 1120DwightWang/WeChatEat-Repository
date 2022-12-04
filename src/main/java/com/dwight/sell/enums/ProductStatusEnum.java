package com.dwight.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "for sale"),
    DOWN(1, "not for sale");

    private final Integer code;

    private final String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
