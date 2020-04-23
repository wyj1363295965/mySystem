package com.tik.mysystem.security.entity;

import lombok.Data;

import javax.persistence.Entity;


/**
 * @author shuang.kou
 */
@Data
public class LoginUser {

    private String username;
    private String password;
    private Boolean rememberMe;

}
