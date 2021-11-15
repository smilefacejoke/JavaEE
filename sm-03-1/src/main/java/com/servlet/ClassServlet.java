package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Class;
import com.pojo.R;
import com.service.ClassService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 54350
 */
@WebServlet("/classes")
public class ClassServlet extends HttpServlet {

    private ClassService classService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext wac= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        classService=wac.getBean(ClassService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 查询所有班级
        List<Class> classes=classService.findAll();

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

//        2. 输出
        resp.getWriter().println(JSON.toJSONString(R.ok().data("list",classes)));
        resp.getWriter().flush();

    }
}
