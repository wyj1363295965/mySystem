package com.tik.mysystem.algorithm;


/**
 * 单例模式（饱汉式）
 */
public class SingletonDemo1 {
    private static SingletonDemo1 INSTANCE = null;

    private SingletonDemo1() {
    }

    /**
     * 调用
     * 只有第一次被调用才会实例化
     * @return
     */
    public static SingletonDemo1 getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new SingletonDemo1();
        }
        return INSTANCE;
    }
}
