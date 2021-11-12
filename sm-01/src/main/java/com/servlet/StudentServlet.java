package com.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.pojo.Student;
import com.service.StudentService;
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
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init(){
//        1. 下面的工具类的作用：是建立tomcat与spring两者之间的桥梁
        WebApplicationContext wac= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        assert wac != null;s
//        2. 从spring容器中得到javabean
        studentService=wac.getBean(StudentService.class);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
//        1. 得到参数，进行方法调用
        String cmd=request.getParameter("cmd");
//        2. 调用不同的方法
        if(StrUtil.isNotBlank(cmd)){
            list(request,response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.1 查询 得到所有学生
        List<Student> students=studentService.findAll();
//        1.2 转换为json对象并输出
        response.getWriter().println(JSON.toJSONString(students));
        response.getWriter().flush();

    }
}
