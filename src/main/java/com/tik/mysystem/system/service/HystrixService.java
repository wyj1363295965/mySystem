package com.tik.mysystem.system.service;

import com.tik.mysystem.system.hystrix.RequestCommand;


public interface HystrixService {

    String getChangeEventData1(String name);


    public static String test1() {
        return null;
    }

    default String test() {
        return null;
    }

    public static String et() {
        return null;
    }
}
