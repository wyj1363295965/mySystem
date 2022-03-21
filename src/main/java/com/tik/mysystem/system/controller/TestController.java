package com.tik.mysystem.system.controller;

import com.tik.mysystem.config.interceptor.LoginRequired;
import com.tik.mysystem.system.entity.WorkWxNotifyVo;
import com.tik.mysystem.system.service.HystrixService;
import com.tik.mysystem.system.service.SynchronizedService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Api(value = "测试接口", tags = {"3"})
@RestController
@RequestMapping("/apitest")
@Slf4j
public class TestController {


    //    @Autowired
//    private RabbitTemplate rabbitTemplate;
    @Autowired
    private HystrixService hystrixService;
    @Autowired
    private SynchronizedService synchronizedService;

    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('TEST')")
    public String registerUser() {
        return "test";
    }


    //@GetMapping("/hello ")  加空格404
    @GetMapping("/hello")
    @LoginRequired(loginSuccess = true)
    public String sayHello() throws InterruptedException {
        try {
            return "hello";
        } finally {
            Thread.sleep(1000 * 5);
            System.out.println("finally执行");
        }
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

//    @RequestMapping(path = "/rabbitMq", method = RequestMethod.GET)
//    public void sendMessage(@RequestParam String name) {
//        rabbitTemplate.convertAndSend("myKey", name);
//    }


    @RequestMapping(path = "/synchronized", method = RequestMethod.GET)
    public String synchronizedMethod(@RequestParam String code) throws Exception {
        return synchronizedService.synchronizedMethod(code).get();
    }


    @RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
    public void uploadFile(@RequestParam MultipartFile pic) throws Exception {
        File file = new File("D:\\wyj\\文档\\" + pic.getOriginalFilename());
        pic.transferTo(file);
        FileSystemResource fs1 = new FileSystemResource(file);
        System.out.println(fs1);
    }
}
