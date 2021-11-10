package com.service;

import com.mapper.ClassMapper;
import com.mapper.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 54350
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClassMapper classMapper;


//    1. 列表查询学生
    @Override
    public List<Student> findAll() {
//        1.1 查询得到所有学生
        List<Student> students = studentMapper.selectByExample(null);
//        1.2 以此添加班级名称
        for(Student student:students){
            student.setCname(classMapper.selectByPrimaryKey(student.getCid()).getCname());
        }
//        1.3 返回数据
        return students;
    }
}
