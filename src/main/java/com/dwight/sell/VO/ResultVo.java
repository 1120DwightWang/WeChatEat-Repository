package com.dwight.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID=3068837394742385883L;
    /*error code*/
    private Integer code;

    /* error message */
    private String msg;

    /*content */
    private T data;
}
