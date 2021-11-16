package com.exp.controller;

import com.exp.pojo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 涛哥
 * @date 2021/11/16
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("list")
    public R list(){
        return R.ok().data("msg","大家好");
    }

}
