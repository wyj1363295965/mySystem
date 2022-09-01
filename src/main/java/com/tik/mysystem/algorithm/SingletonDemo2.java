package com.tik.mysystem.algorithm;

/**
 * 单例模式（饿汉式-双重检查）
 */
public class SingletonDemo2 {

    private volatile static SingletonDemo2 INSTANCE = null;

    private SingletonDemo2() {
    }

    //调用
    public static SingletonDemo2 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDemo2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDemo2();
                }
            }
        }
        return INSTANCE;
    }

}


