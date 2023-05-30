package com.ewinner.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class BeanFactoryApplicationTests {
    public static void main(String[] args) {
        //创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建一个读取器读取xml文件
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //读取器配置文件传递给工厂
        reader.loadBeanDefinitions("beans.xml");
        //根据id获取对象
        Object userService = beanFactory.getBean("userServiceBean");
        System.out.println("---------------\n" + userService);

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userDaoBean = applicationContext.getBean("userDaoBean");
        System.out.println("---------------\n" + userDaoBean);

        Object bookBean = applicationContext.getBean("bookService");
        System.out.println("---------------\n静态工厂实例化\n" + bookBean);

        Object bookBean2 = applicationContext.getBean("bookService2");
        System.out.println("---------------\n实例工厂实例化\n" + bookBean2);

        Object bookBean3 = applicationContext.getBean("bookService3");
        System.out.println("---------------\nFactoryBean实例\n" + bookBean3);

        Object bookBean4 = applicationContext.getBean("bookService4");
        System.out.println("---------------\nFactoryBean list test\n" + bookBean4);

        applicationContext.close();
    }

}
