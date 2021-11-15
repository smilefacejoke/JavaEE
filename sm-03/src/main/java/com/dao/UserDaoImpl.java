package com.dao;

/**
 * @author 涛哥
 * @date 2021/11/12
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("add++++");
    }

    @Override
    public void query() {
        System.out.println("query++++");

    }

    @Override
    public void update() {
        System.out.println("update++++");

    }

    @Override
    public void delete() {
        System.out.println("delete++++");

    }
}
