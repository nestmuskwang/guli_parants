package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherQueryVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author wangsg
 * @since 2021-09-22
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQueryList(Page<EduTeacher> eduTeacherPage, TeacherQueryVO teacherQueryVO);
}
