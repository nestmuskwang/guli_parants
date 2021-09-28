package com.atguigu.servicebase.globle;


import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author wangshuguang
 * @Date 2021/9/27 15:56
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R GlobalExceptionHandler(Exception exception){

        return R.error().message("执行全局异常处理");
    }


    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){

        return R.error().message("执行了数字计算异常处理方法");
    }

    @ExceptionHandler(MyGlobalException.class)
    @ResponseBody
    public R error(MyGlobalException e){

        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
