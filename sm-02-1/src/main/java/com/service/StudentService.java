package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Student;
import com.pojo.vo.StudentVo;

import java.util.List;

/**
 * @author 54350
 */
public interface StudentService {


    List<Student> findAll();

    PageInfo<Student> search(int page, int pageSize, StudentVo studentVo);

    void insert(Student student);

    void update(Student student);

    void delete(String id);
}
