package com.zelin.web.controller;

import com.zelin.pojo.R;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/12-10:03
 * ------------------------------
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    //1. 查询所有班级
    @GetMapping("/list")
    @ResponseBody
    public R list(){
        return R.ok().data("list",classesService.findAll());
    }
}
