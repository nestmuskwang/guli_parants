package com.atguigu.serviceedu.controller;



import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherQueryVO;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R list(){
        return  R.ok().data("item",eduTeacherService.list(null));
    }

    @GetMapping("delete")
    @ApiOperation(value = "删除讲师")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType="String")
    public R removeById(@RequestParam String id){
        boolean b = eduTeacherService.removeById(id);
        return  R.ok().data("data",b);
    }

    @GetMapping("pageList")
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",value = "当前页面数",paramType = "query",dataType = "Long",defaultValue = "1"),
            @ApiImplicitParam(name = "size",value = "每页数量",paramType = "query",dataType = "Long",defaultValue = "5")
    } )
    public R pageList(@RequestParam Long current, @RequestParam Long size){

        Page<EduTeacher> page = new Page<>(current,size);

        eduTeacherService.page(page, null);

        return R.ok().data("tatal",page.getTotal()).data("rows",page.getRecords()).data("pages",page.getPages());
    }
    @PostMapping("pageQueryList")
    @ApiOperation(value = "条件分页查询")
    public R pageQueryList(
            @ApiParam(name = "current", value = "当前页码", required = true) @RequestParam Long current ,
            @ApiParam(name = "size", value = "每页记录数", required = true) @RequestParam Long size,
            @ApiParam(name = "teacherQueryVO", value = "条件查询对象", required = false)  @RequestBody TeacherQueryVO teacherQueryVO){
        Page<EduTeacher> eduTeacherPage = new Page<>(current,size);
        eduTeacherService.pageQueryList(eduTeacherPage,teacherQueryVO);
        return R.ok().data("total",eduTeacherPage.getTotal()).data("rows",eduTeacherPage.getRecords()).data("pageSize",eduTeacherPage.getPages());
    }
}

