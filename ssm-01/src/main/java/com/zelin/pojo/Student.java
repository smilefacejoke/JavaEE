package com.zelin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Table(name = "student")
public class Student implements Serializable {

    @Id                     //代表学生表的主键
    private Integer sid;

    private String sname;

    private String sex;

    private Integer age;

    private String addr;

    private Integer cid;

    @Transient          //代表在数据表中没有此字段
    private String cname;


}