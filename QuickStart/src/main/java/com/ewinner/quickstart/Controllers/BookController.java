package com.ewinner.quickstart.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    @RequestMapping("/GetBookById")
    public String getById(){
        System.out.println("SpringBoot is running");
        return "SpringBoot is running";
    }
}
