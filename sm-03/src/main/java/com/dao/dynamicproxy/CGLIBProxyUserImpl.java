package com.dao.dynamicproxy;


import com.dao.UserDao;
import com.dao.UserDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 涛哥
 * @date 2021/11/13
 */
public class CGLIBProxyUserImpl implements MethodInterceptor {

    //1. 创建代理对象
    public UserDaoImpl createProxy(){
        //1.1 构建一个enhancer对象
        Enhancer enhancer=new Enhancer();
        //1.2 指定enhancer的父类
        enhancer.setSuperclass(UserDaoImpl.class);
        //1.3 指定回调
        enhancer.setCallback(this);
        //1.4 创建代理对象
        Object o=enhancer.create();
        //1.5 返回
        return (UserDaoImpl) o;
    }


    //2. 调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("query".equals(method.getName())){
            check();
        }
        return methodProxy.invokeSuper(o, objects); //代理类所对应方法调用其父类的方法
    }

    //3. 进行安全性检查
    public void check(){
        System.out.println(" ========安全===");
    }
}
