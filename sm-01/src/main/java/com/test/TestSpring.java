package com.test;

import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 54350
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-01.xml")
public class TestSpring {

    private ApplicationContext ac;
    @Before
    public void init(){
        ac=new ClassPathXmlApplicationContext("classpath:spring/spring-01.xml");
    }

//    1. 构造对象的几种方法:通过无参构造方法获取
    @Test
    public void test01(){
//        1.1 直接通过配置
        Object stud01=ac.getBean("stud01");
        System.out.println("stud01 = " + stud01);
    }

//    2. 构造对象的方法二：通过静态工厂方法获取
    @Test
    public void test02(){
        Object stud02=ac.getBean("stud01");
        System.out.println("stud02 = " + stud02);
    }

//    3. 构造对象的方法三：通过工厂方法获取
    @Test
    public void test03(){
        Object stud03 = ac.getBean("stud03");
        System.out.println("stud03 = " + stud03);
    }

//    4. 为对象赋值 方法一：使用setter方法赋值
    @Test
    public void test04(){
        Object stud11 = ac.getBean("stud11");
        System.out.println("stud11 = " + stud11);
    }
//    5. 方法二：使用构造方法赋值
    @Test
    public void test05(){
        Object stud12 = ac.getBean("stud12");
        System.out.println("stud11 = " + stud12);
    }
//    6. 方法三：使用p名称赋值
    @Test
    public void test06(){
        Object stud13 = ac.getBean("stud13");
        System.out.println("stud13 = " + stud13);
    }

//    7. 复杂属性的赋值
    @Test
    public void test07(){
        Object cd = ac.getBean("cd");
        System.out.println("cd = " + cd);
    }



}
