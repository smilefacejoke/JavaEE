package com.zelin.web.controller;

import com.github.pagehelper.PageInfo;
import com.zelin.pojo.R;
import com.zelin.pojo.Student;
import com.zelin.pojo.vo.StudentVo;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/12-9:45
 * ------------------------------
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //1. 列表学生
    @RequestMapping("/list")
    //@ResponseBody     //将java对象转换为json串
    public R list(){
        //1.1 查询所有学生
        List<Student> all = studentService.findAll();
        //1.2 放到R对象中并返回
        return R.ok().data("list",all);
    }
    //2. 条件查询带分页
    @PostMapping("/search")
    //@RequestBody 将前端传入的json串转换为java对象
    public R search(int page, int pageSize, @RequestBody(required = false) StudentVo vo){
        System.out.println("page = " + page);
        System.out.println("pageSize = " + pageSize);
        System.out.println("vo = " + vo);
        //2.1 根据条件查询得到分页结果
        PageInfo<Student> studentPageInfo = studentService.search(page,pageSize,vo);
        //2.2 返回
        return R.ok().data("total",studentPageInfo.getTotal()).data("rows",studentPageInfo.getList());
    }
    //3. 添加学生
    @PostMapping("/add")
    public R add(@RequestBody Student student){
        studentService.add(student);
        return R.ok();
    }

    //4. 修改学生
    @PostMapping("/update")
    public R update(@RequestBody Student student){
        studentService.update(student);
        return R.ok();
    }

    //5. 根据学号删除学生
    @GetMapping("/delete")
    public R delete(Integer[] ids){
        studentService.delete(ids);
        return R.ok();
    }
}
