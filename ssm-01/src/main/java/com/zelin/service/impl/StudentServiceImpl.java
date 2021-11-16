package com.zelin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zelin.mapper.ClassesMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Student;
import com.zelin.pojo.vo.StudentVo;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/9-11:00
 * ------------------------------
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;
    //1. 列表查询学生
    @Override
    public List<Student> findAll() {
        //1.1 查询所有学生
        List<Student> students = studentMapper.selectByExample(null);
        //1.2 为每个学生添加班级名称
        for (Student student : students) {
         student.setCname(classesMapper.selectByPrimaryKey(student.getCid()).getCname());
        }
        //1.3 返回
        return students;
    }

    //2. 条件查询带分页
    @Override
    public PageInfo<Student> search(int page, int pageSize, StudentVo vo) {
        //2.1 开始分页查询
        PageHelper.startPage(page,pageSize);
        //2.2 开始查询
        //2.2.1 构造查询实例
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        //2.2.2 添加实例查询条件
        if(vo != null){
            if(StrUtil.isNotBlank(vo.getSname())){
                criteria.andLike("sname","%" + vo.getSname() + "%");
            }
            if(StrUtil.isNotBlank(vo.getAddr())){
                criteria.andLike("addr","%" + vo.getAddr() + "%");
            }
            if(vo.getCid() != 0){
                criteria.andEqualTo("cid",vo.getCid());
            }
        }
        List<Student> students = studentMapper.selectByExample(example);
        //2.2.3 对查询学生添加班级名称
        for (Student student : students) {
            student.setCname(classesMapper.selectByPrimaryKey(student.getCid()).getCname());
        }
        //2.3 返回PageInfo
        return new PageInfo<>(students);
    }

    //3. 保存学生
    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    //4. 修改学生
    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    //5. 删除学生
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            studentMapper.deleteByPrimaryKey(id);
        }
    }


}
