package com.tik.mysystem.system.controller;

import com.tik.mysystem.system.entity.WorkWxNotifyVo;
import com.tik.mysystem.system.hystrix.RequestCommand;
import com.tik.mysystem.system.service.HystrixService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Api(value = "测试接口", tags = {"3"})
@RestController
@RequestMapping("/apitest")
@Slf4j
public class TestController {


    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Reference
    private HystrixService hystrixService;

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

    @RequestMapping(path = "/workWxNotify", method = RequestMethod.POST)
    public void getChangeEventData(@RequestBody WorkWxNotifyVo workWxNotifyVo, HttpServletRequest request) throws IOException {
        System.out.println(workWxNotifyVo);
        InputStream inputStream = request.getInputStream();
        String sPostData = IOUtils.toString(inputStream, "UTF-8");
        log.info("sPostData：{}", sPostData);
    }

    @RequestMapping(path = "/workWxNotify1", method = RequestMethod.POST)
    public void getChangeEventData1(@RequestBody WorkWxNotifyVo workWxNotifyVo) throws IOException {
        System.out.println(workWxNotifyVo);
    }

    @RequestMapping(path = "/hystrix", method = RequestMethod.GET)
    public String getChangeEventData1(@RequestParam String name) {
        return hystrixService.getChangeEventData1(name);
    }

    @RequestMapping(path = "/rabbitMq", method = RequestMethod.GET)
    public void sendMessage(@RequestParam String name) {
        rabbitTemplate.convertAndSend("myKey", name);
    }
}
