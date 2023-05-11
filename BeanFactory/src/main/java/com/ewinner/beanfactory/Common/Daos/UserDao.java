package com.ewinner.beanfactory.Common.Daos;

import com.ewinner.beanfactory.Interface.IUserDao;

public class UserDao implements IUserDao {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
        System.out.println("Auto invoke by Factory:" + userDao);
    }
}
