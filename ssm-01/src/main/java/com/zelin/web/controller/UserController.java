package com.zelin.web.controller;

import com.zelin.pojo.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/12-9:50
 * ------------------------------
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //1. 用户登录
    @PostMapping("/login")
    //@ResponseBody           //将java对象转换为json串
    public R login(){
        return R.ok().data("token",1);
    }

    //2. 登录成功后用户信息
    @GetMapping("/info")
    //@ResponseBody
    public R info(){
        return R.ok().data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    //3. 注销功能
    @GetMapping("/logout")
    public R logout(){
        return R.ok();
    }

}
