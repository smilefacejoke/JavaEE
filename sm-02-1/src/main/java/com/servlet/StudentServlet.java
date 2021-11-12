package com.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.pojo.Student;
import com.pojo.vo.StudentVo;
import com.service.R;
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
import java.util.Objects;

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
            if("list".equals(cmd)){
                list(request,response);
            }else if("search".equals(cmd)){
                search(request,response);
            }else if("add".equals(cmd)){
                add(request,response);
            }else if("update".equals(cmd)){
                update(request,response);
            }else if("delete".equals(cmd)){
                delete(request,response);
            }
        }
    }




    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.1 查询 得到所有学生
        List<Student> students=studentService.findAll();
//        1.2 转换为json对象并输出
        response.getWriter().println(JSON.toJSONString(students));
        response.getWriter().flush();

    }

    //2. 分页带条件查询
    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        2.1 得到分页参数
        int page=Integer.parseInt(request.getParameter("page"));
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
//        2.2 得到分页的查询参数
        String stud=request.getParameter("stud");
        StudentVo studentVo = JSON.parseObject(stud, StudentVo.class);
//        2.3 开始条件查询带分页
        PageInfo<Student> studentPageInfo=studentService.search(page,pageSize,studentVo);
//        2.4 将数据放到R对象中
        R r = Objects.requireNonNull(R.ok().put("total", studentPageInfo.getTotal())).put("rows", studentPageInfo.getList());
//        2.5 转换为字符串并输出
        response.getWriter().println(JSON.toJSONString(r));
        response.getWriter().flush();
    }

    //3.添加学生
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //4.1 得到学生信息
        String stud=request.getParameter("stud");
        Student student=JSON.parseObject(stud,Student.class);
        //4.2 添加学生
        studentService.insert(student);
        //4.3 转换为字符串并输出
        response.getWriter().println(JSON.toJSONString(R.ok()));
        response.getWriter().flush();

    }

    //4. 更新学生信息
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //4.1 得到学生信息
        String stud=request.getParameter("stud");
        Student student=JSON.parseObject(stud,Student.class);
        //4.2 添加学生
        studentService.update(student);
        //4.3 转换为字符串并输出
        response.getWriter().println(JSON.toJSONString(R.ok()));
        response.getWriter().flush();
    }

    //5. 删除学生
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //5.1 得到要删除的学生学号
        String stud=request.getParameter("ids");
        String[] split=stud.split(",");
        for(String id:split){
            studentService.delete(id);
        }
        //5.2转换为字符串并输出
        response.getWriter().println(JSON.toJSONString(R.ok()));
        response.getWriter().flush();

    }



}



