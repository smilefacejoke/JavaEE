package com.dao.test;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.dao.dynamicproxy.CGLIBProxyUserImpl;
import com.dao.dynamicproxy.JDKProxyUserImpl;
import com.dao.staticproxy.USerDaoStaticProxyImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 涛哥
 * @date 2021/11/12
 */
public class TestUserDao {

    private UserDao userDao;

    private JDKProxyUserImpl jdkProxyUser;

    private CGLIBProxyUserImpl cglibProxyUser;

    @Before
    public void init(){
        //1. 静态代理对象
        userDao=new USerDaoStaticProxyImpl();
        //2. 得到JDKProxyUser对象
        jdkProxyUser=new JDKProxyUserImpl();
        //3. 得到CGLI对象
        cglibProxyUser=new CGLIBProxyUserImpl();
    }


    //1. 静态代理测试
    @Test
    public void test01(){
        //userDao.add();
        userDao.query();
    }

    //2. 动态代理查询
    @Test
    public void test02(){

        //2.1 利用jdk生成动态代理对象
        UserDao proxy=jdkProxyUser.createProxy();
        //2.2 进行方法调用
        proxy.add();
        System.out.println(" ---------------------");
        proxy.query();

    }

    //3.动态代理测试
    @Test
    public void test03(){
        //3.1 得到代理对象
        UserDaoImpl proxy=cglibProxyUser.createProxy();
        //3.2 调用目标方法
        proxy.add();
        System.out.println(" ==========");
        proxy.query();
    }

}
