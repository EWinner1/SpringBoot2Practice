package com.ewinner.beanfactory.Common.Daos;

import com.ewinner.beanfactory.Interface.IUserDao;
import org.springframework.beans.factory.InitializingBean;

public class UserDao implements IUserDao, InitializingBean {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
        System.out.println("Auto invoke by Factory:" + userDao);
    }
    public void init(){
        System.out.println("Init method...\n" + userDao);
    }

    public void destroy(){
        System.out.println("Destroy method...\n" + userDao);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }
}
