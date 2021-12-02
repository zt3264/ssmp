package com.zt.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//作为springMVC的异常处理器
@RestControllerAdvice
public class projectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception e){
        e.printStackTrace();
        return new R("服务器故障，请稍候再试！");
    }
}
