package com.serviceinfotech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public String sayHello() {

        LOGGER.info("**I am info");
        LOGGER.debug("**I am Debug");
        LOGGER.trace("**I am Trace");
        LOGGER.error("**I am error");
        return "Hello";
    }
}
