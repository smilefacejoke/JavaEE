package com.dao.dynamicproxy;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.PrivateKey;

/**
 * @author 涛哥
 * @date 2021/11/12
 */
public class JDKProxyUserImpl implements InvocationHandler {

    //1. 引入目标对象
    private UserDao userDao;

    public JDKProxyUserImpl(){
        userDao=new UserDaoImpl();
    }

    //2. 使用Proxy生成代理对象
    public UserDao createProxy(){
        //2.1
        // 参数1：代表目标对象的类加载器
        // 参数2: 代表目标对象实现的接口的类型
        // 参数3：代表实现了InvocationHandler接口的对象
        return (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
    }

    //3. 通过反射调用目标方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //3.1 如果调用的是query方法，就进行安全性检查
        if(method.getName().equals("query")){       //method.getName():代表得到目标对象的方法名
            checkSecurity();
            return method.invoke(userDao,args);     //参数1：代表调用方法的哪个目标对象 参数2：代表方法传递的参数
        }
        return null;
    }

    //4. 检查安全性
    private void checkSecurity(){
        System.out.println("JDKProxyUserImpl------>安全性检查");
    }

}
