package com.tik.mysystem.algorithm;

/**
 * 单例模式（饿汉式）
 */
public class SingletonDemo {

    private final static SingletonDemo INSTANCE = new SingletonDemo();

    private SingletonDemo() {
    }

    //调用
    public static SingletonDemo getInstance() {
        return INSTANCE;
    }

}


