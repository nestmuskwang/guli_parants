package com.atguigu.serviceedu.controller;


import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wangsg
 * @since 2021-09-22
 */
@Api(description="讲师管理")
@RestController
@RequestMapping("/serviceedu/edu-teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("get")
    @ApiOperation(value = "所有讲师列表")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType="String")
    public List<EduTeacher> list(){
        return eduTeacherService.list(null);
    }

    @GetMapping("delete")
    @ApiOperation(value = "删除讲师")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType="String")
    public boolean removeById(@RequestParam String id){
        return eduTeacherService.removeById(id);
    }
}

