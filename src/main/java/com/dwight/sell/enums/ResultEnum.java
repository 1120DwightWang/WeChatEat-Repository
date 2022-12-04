package com.dwight.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"Success"),
    PARAM_ERROR(1,"parameters invalid"),

    PRODUCT_NOT_EXIST(10,"product does not exist"),
    PRODUCT_STOCK_ERROR(11,"product stock invalid"),
    ORDER_NOT_EXIST(12,"order does not exist"),
    ORDERDETAIL_NOT_EXIST(13,"order detail does not exist"),

    ORDER_STATUS_ERROR(14,"order status invalid"),

    ORDER_UPDATE_FAIL(15,"order update failed"),

    ORDER_DETAIL_EMPTY(16,"order detail is empty"),

    ORDER_PAY_STATUS_ERROR(17,"order payment status error"),

    CART_EMPTY(18,"cart is empty"),

    ORDER_OWNER_ERROR(19,"this order doesn't belong to user"),

    WECHAT_MP_ERROR(20,"wechat official account error"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"notice amount failed to be verified"),

    ORDER_CANCEL_SUCCESS(22,"order cancelled successfully"),
    ORDER_FINISH_SUCCESS(23, "order finished successfully"),

    PRODUCT_STATUS_ERROR(24,"product status error"),

    LOGIN_FAIL(25,"login info incorrect"),

    LOGOUT_SUCCESS(26,"successfully logged out");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
