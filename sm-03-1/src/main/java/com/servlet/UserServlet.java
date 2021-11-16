package com.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.exp.pojo.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 涛哥
 * @date 2021/11/15
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置响应页面的字符编码
        resp.setContentType("text/html;charset=utf8");
        //1. 得到请求参数
        String cmd=req.getParameter("cmd");
        //2. 根据参数的不同进行分选
        if(StrUtil.isNotBlank(cmd)){
            if("login".equals(cmd)){
                login(req,resp);
            }else if("info".equals(cmd)){
                info(req,resp);
            }else if("logout".equals(cmd)){
                logout(req,resp);
            }
        }
    }


    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 处理登录数据
        R token = R.ok().data("token", 1);
        //2. 将数据输出
        resp.getWriter().println(JSON.toJSONString(token));
        resp.getWriter().flush();
    }

    //处理查看信息页面
    private void info(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 定义R对象
        R r=R.ok().data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        //2. 将r对象输出到前端页面
        resp.getWriter().println(JSON.toJSONString(r));
        resp.getWriter().flush();

    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) {
    }


}
