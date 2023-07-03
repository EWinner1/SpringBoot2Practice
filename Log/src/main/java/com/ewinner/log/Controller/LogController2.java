package com.ewinner.log.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log2")
public class LogController2 {
    @PutMapping
    public Boolean logInfo(@RequestBody String string) {
        log.info(string);
        return true;
    }
}
