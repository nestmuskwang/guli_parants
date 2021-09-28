package com.atguigu.servicebase.globle;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wangshuguang
 * @Date 2021/9/28 14:11
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyGlobalException  extends  RuntimeException{
    @ApiModelProperty(value = "状态码值")
    private  Integer  code;
    @ApiModelProperty(value = "错误信息")
    private String msg;

}
