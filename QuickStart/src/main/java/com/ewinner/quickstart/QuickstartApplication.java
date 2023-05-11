package com.ewinner.quickstart;

import com.ewinner.quickstart.Common.Models.User;
import com.ewinner.quickstart.Controllers.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuickstartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(QuickstartApplication.class, args);
        BookController bean = ctx.getBean(BookController.class);
        System.out.println("-------------------" + "\n" + bean);
        User userBean = ctx.getBean(User.class);
        System.out.println("-------------------" + "\n" + userBean);
    }

}
