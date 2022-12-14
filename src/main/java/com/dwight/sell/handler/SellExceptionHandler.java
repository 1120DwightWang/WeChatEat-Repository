package com.dwight.sell.handler;

import com.dwight.sell.VO.ResultVo;
import com.dwight.sell.config.ProjectUrlConfig;
import com.dwight.sell.exception.SellException;
import com.dwight.sell.exception.SellerAuthorizeException;
import com.dwight.sell.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value= SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value= SellException.class)
    @ResponseBody
    public ResultVo handlerSellerException(SellException e){
        return ResultVoUtil.error(e.getCode(),e.getMessage());
    }
}
