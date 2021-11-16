package com.exp.service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.exp.mapper.ClassMapper;
import com.exp.mapper.StudentMapper;
import com.exp.pojo.Student;
import com.exp.pojo.StudentExample;
import com.exp.pojo.vo.StudentVo;
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

    //    2. 分页带条件查询学生信息
    @Override
    public PageInfo<Student> search(int page, int pageSize, StudentVo studentVo) {
//        2.1 开始分页
        PageHelper.startPage(page,pageSize);
//        2.2 开始查询
//        2.2.1 定义查询实例
        StudentExample example=new StudentExample();
        StudentExample.Criteria criteria=example.createCriteria();
//        2.2.2 为criteria对象添加查询条件
        if(studentVo!=null){
            if(StrUtil.isNotBlank(studentVo.getName())){
                criteria.andNameLike("%"+studentVo.getName()+"");
            }
            if(StrUtil.isNotBlank(studentVo.getAddr())){
                criteria.andAddrLike("%"+studentVo.getAddr()+"");
            }
            if(studentVo.getCid()!=0){
                criteria.andCidEqualTo(studentVo.getCid());
            }
        }
        //2.2.3 开始条件查询
        List<Student> students=studentMapper.selectByExample(example);
//        2.2.4 将得到的学生对象绑定班级名称
        for(Student student:students){
            student.setCname(classMapper.selectByPrimaryKey(student.getCid()).getCname());
        }

//        2.3 转换为pageInfo对象并返回
        return new PageInfo<>(students);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public void delete(String id) {
        studentMapper.deleteByPrimaryKey(new Integer(id));
    }

}

