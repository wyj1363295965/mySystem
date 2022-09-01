package com.tik.mysystem.algorithm;

import com.tik.mysystem.system.entity.User;

/**
 * 单例模式（枚举方式，最安全）
 */
public enum SingletonDemo3 {
    INSTANCE;

    private User uniqueUser;

    private SingletonDemo3() {
        uniqueUser = new User();
    }

    //调用
    public User getInstance() {
        return uniqueUser;
    }

}


