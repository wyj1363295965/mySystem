package com.tik.mysystem.security.controller;


import com.tik.mysystem.security.entity.LoginUser;
import com.tik.mysystem.system.entity.User;
import com.tik.mysystem.system.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(value = "权限接口", tags = {"2"})
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public void registerUser(@RequestBody LoginUser user) {
        userService.saveUser(user);
    }

//    @PostMapping("/login")
//    public boolean login(@RequestBody LoginUser user) {
//        return userService.login(user);
//    }
}
