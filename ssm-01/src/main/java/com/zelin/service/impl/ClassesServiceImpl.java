package com.zelin.service.impl;

import com.zelin.mapper.ClassesMapper;
import com.zelin.pojo.Classes;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/10-9:36
 * ------------------------------
 */
@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    //1. 查询所有班级
    // @Override
    @Override
    public List<Classes> findAll() {
        return classesMapper.selectByExample(null);
    }
}
