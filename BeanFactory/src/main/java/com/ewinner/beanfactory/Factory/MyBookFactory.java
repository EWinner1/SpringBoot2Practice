package com.ewinner.beanfactory.Factory;

import com.ewinner.beanfactory.Interface.IBookService;
import com.ewinner.beanfactory.Service.BookService;

import java.util.List;

public class MyBookFactory {

    private List<String> stringList;

    public static IBookService bookService() {
        //进行其他业务逻辑操作
        return new BookService();
    }

    public IBookService bookService2() {
        //进行其他业务逻辑操作
        return new BookService();
    }

    public void setList(List<String> list) {
        this.stringList = list;
    }
}
