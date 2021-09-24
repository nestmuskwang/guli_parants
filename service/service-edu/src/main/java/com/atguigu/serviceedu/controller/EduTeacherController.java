package com.atguigu.serviceedu.controller;



import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
        eduTeacherService.removeById(id);
        return  R.ok();
    }

    @GetMapping
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current",value = "当前页面数",paramType = "query",dataType = "Long"),
            @ApiImplicitParam(name = "size",value = "每页数量",paramType = "query",dataType = "Long")
    } )
    public R pageList(@RequestParam Long current, @RequestParam Long size){

        Page<EduTeacher> page = new Page<>(current,size);

        eduTeacherService.page(page, null);

        return R.ok().data("tatal",page.getTotal()).data("rows",page.getRecords());
    }

}

