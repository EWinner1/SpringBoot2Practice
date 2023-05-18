package com.ewinner.beanfactory.Factory;

import com.ewinner.beanfactory.Interface.IBookService;
import com.ewinner.beanfactory.Service.BookService;
import org.springframework.beans.factory.FactoryBean;

public class MyBookFactory2 implements FactoryBean<IBookService> {
    @Override
    public IBookService getObject() throws Exception {
        return new BookService();
    }

    @Override
    public Class<?> getObjectType() {
        return BookService.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
