package com.ewinner.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryApplication {

    public static void main(String[] args) {
        //创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建一个读取器读取xml文件
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //读取器配置文件传递给工厂
        reader.loadBeanDefinitions("Beans.xml");
        //根据id获取对象
        Object userService = beanFactory.getBean("userServiceBean");
        System.out.println("---------------\n" + userService);

        Object userDaoService = beanFactory.getBean("userDaoBean");
        System.out.println("---------------\n" + userDaoService);
    }

}
