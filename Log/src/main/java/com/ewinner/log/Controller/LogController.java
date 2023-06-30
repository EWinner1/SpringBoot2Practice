package com.ewinner.log.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @PutMapping
    public Boolean logInfo(@RequestBody String string) {
        log.info(string);
        return true;
    }

    @PutMapping
    public Boolean logWarning(@RequestBody String string) {
        log.warn(string);
        return true;
    }

    @PutMapping
    public Boolean logError(@RequestBody String string) {
        log.error(string);
        return true;
    }

    @PutMapping
    public Boolean logDebug(@RequestBody String string) {
        log.debug(string);
        return true;
    }
    //log.trace()不常用;
}