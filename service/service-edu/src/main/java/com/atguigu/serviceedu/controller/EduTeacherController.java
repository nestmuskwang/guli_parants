package com.atguigu.serviceedu.controller;


import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wangsg
 * @since 2021-09-22
 */
@RestController
@RequestMapping("/serviceedu/edu-teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping
    public List<EduTeacher> list(){
        return eduTeacherService.list(null);
    }

}

