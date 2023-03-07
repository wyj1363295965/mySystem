package com.tik.mysystem.algorithm;

import com.tik.mysystem.system.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例模式（枚举方式，最安全）
 */
@Slf4j
public enum SingletonDemo3 {
    INSTANCE;

    private User uniqueUser;

    private SingletonDemo3() {
        uniqueUser = new User();
        System.out.println("设置参数");
        uniqueUser.setUsername("2222");
    }

    private void test() {

    }

    //调用
    public User getInstance() {
        return uniqueUser;
    }

}


