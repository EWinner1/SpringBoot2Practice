package com.ewinner.log.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilsClass {
    private final Class clazz;
    public final Logger log;

    public UtilsClass() {
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }
}
