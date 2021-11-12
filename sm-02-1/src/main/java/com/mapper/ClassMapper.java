package com.mapper;

import com.pojo.Class;
import com.pojo.ClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);

    Class selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}