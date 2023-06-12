package com.ewinner.ssmptest.Common.Utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//或者@ControllerAdvice
public class ProjectExceptionHandler {
    @ExceptionHandler
    public Result handlerException(Exception exception){
        exception.printStackTrace();
        return new Result(false, null, exception.getMessage());
    }
}
