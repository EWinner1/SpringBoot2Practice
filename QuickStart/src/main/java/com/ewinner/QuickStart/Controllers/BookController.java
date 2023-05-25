package com.ewinner.QuickStart.Controllers;

import org.springframework.web.bind.annotation.*;

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
