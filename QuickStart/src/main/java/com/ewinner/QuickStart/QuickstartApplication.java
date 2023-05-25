package com.ewinner.QuickStart;

import com.ewinner.QuickStart.Common.Models.User;
import com.ewinner.QuickStart.Controllers.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuickstartApplication {
    //引导类将会自动扫描当前包下的Bean
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(QuickstartApplication.class, args);
        BookController bean = ctx.getBean(BookController.class);
        System.out.println("-------------------" + "\n" + bean);
        User userBean = ctx.getBean(User.class);
        System.out.println("-------------------" + "\n" + userBean);
    }

}
