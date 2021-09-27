package com.atguigu.serviceedu.service.impl;

import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherQueryVO;
import com.atguigu.serviceedu.mapper.EduTeacherMapper;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author wangsg
 * @since 2021-09-22
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQueryList(Page<EduTeacher> eduTeacherPage, TeacherQueryVO teacherQueryVO) {
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("sort");
        if (null == teacherQueryVO){
            baseMapper.selectPage(eduTeacherPage,queryWrapper);
            return;
        }
        if(!StringUtils.isEmpty(teacherQueryVO.getName())){
            queryWrapper.like("name",teacherQueryVO.getName());
        }
        if(!StringUtils.isEmpty(teacherQueryVO.getLevel())){
            queryWrapper.eq("level",teacherQueryVO.getLevel());
        }
        if(!StringUtils.isEmpty(teacherQueryVO.getBeginTime())){
            queryWrapper.ge("create_time",teacherQueryVO.getBeginTime());
        }
        if(!StringUtils.isEmpty(teacherQueryVO.getEndTime())){
            queryWrapper.le("create_time",teacherQueryVO.getEndTime());
        }
        baseMapper.selectPage(eduTeacherPage,queryWrapper);
    }
}
