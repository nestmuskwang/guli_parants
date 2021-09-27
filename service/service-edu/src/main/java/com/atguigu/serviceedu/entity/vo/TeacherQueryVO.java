package com.atguigu.serviceedu.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * @Author wangshuguang
 * @Date 2021/9/27 11:40
 * @Version 1.0
 */
@Data
@ApiModel(value = "讲师条件封装" ,description = "讲师查询对象封装")
public class TeacherQueryVO implements Serializable {
    @ApiModelProperty(value = "模糊查询姓名")
    private String name;
    @ApiModelProperty(value = "条件查询等级")
    private Integer level;
    @ApiModelProperty(value = "开始时间", example = "2019-01-01 10:10:10")
    private String  beginTime;
    @ApiModelProperty(value = "结束时间", example = "2019-01-01 10:10:10")
    private String  endTime;

}
