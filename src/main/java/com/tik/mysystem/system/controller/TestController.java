package com.tik.mysystem.system.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "测试接口", tags = {"3"})
@RestController
@RequestMapping("/apitest")
public class TestController {

    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('TEST')")
    public String registerUser() {
        return "test";
    }


    //@GetMapping("/hello ")  加空格404
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
