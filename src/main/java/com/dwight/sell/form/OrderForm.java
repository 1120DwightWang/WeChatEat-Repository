package com.dwight.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "name required")
    private String name;
    @NotEmpty(message ="phone number required")
    private String phone;
    @NotEmpty(message = "address required")
    private String address;

    @NotEmpty(message ="openid required")
    private String openid;

    @NotEmpty(message = "cart mustn't be empty")
    private String items;

}
