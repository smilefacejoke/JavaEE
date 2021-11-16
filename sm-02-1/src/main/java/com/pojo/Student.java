package com.exp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer sid;

    private String name;

    private String sex;

    private Integer age;

    private String addr;

    private Integer cid;

    private String cname;

    private static final long serialVersionUID = 1L;


}