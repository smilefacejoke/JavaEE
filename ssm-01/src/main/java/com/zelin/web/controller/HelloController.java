package com.zelin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/12-9:39
 * ------------------------------
 */
@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello(){
        return new ModelAndView("hello","username","张三");
    }
}
