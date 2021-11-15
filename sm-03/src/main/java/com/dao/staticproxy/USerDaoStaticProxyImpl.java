package com.dao.staticproxy;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

/**
 * @author 涛哥
 * @date 2021/11/12
 */
public class USerDaoStaticProxyImpl implements UserDao {
    private UserDao userDao;
    public USerDaoStaticProxyImpl(){
        userDao=new UserDaoImpl();
    }

    @Override
    public void add() {
        userDao.add();
    }

    @Override
    public void query() {
        checkSecurity();
        userDao.query();
    }

    @Override
    public void update() {
        userDao.update();
    }

    @Override
    public void delete() {
        userDao.delete();
    }

    private void checkSecurity(){
        System.out.println("进行安全性检测。。。");
    }

}
