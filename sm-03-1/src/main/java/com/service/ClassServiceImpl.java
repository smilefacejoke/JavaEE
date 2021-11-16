package com.exp.service;

import com.exp.mapper.ClassMapper;
import com.exp.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 54350
 */
@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassMapper classMapper;


    //1. 查询所有班级
    @Override
    public List<Class> findAll() {
        return classMapper.selectByExample(null);
    }
}
