package com.factory;

import com.exp.pojo.Student;

/**
 * @author 54350
 */
public class StudentFactory2 {
    public Student getStudent(){
        return new Student();
    }
}
