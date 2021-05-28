package com.tik.mysystem.system.controller;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试接口", tags = {"3"})
@RestController
@RequestMapping("/apitest")
public class TestController {

    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('TEST')")
    public String registerUser() {
        return "test";
    }
}
