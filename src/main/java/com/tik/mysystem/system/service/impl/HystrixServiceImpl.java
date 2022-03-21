package com.tik.mysystem.system.service.impl;

import com.tik.mysystem.system.hystrix.RequestCommand;
import com.tik.mysystem.system.service.HystrixService;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
//import org.apache.dubbo.config.annotation.Service;

@Service
public class HystrixServiceImpl implements HystrixService {

    ThreadLocal<String> testStr = new ThreadLocal<>();

    public String getChangeEventData1(String name) {
        testStr.set("1");

        String get = testStr.get();

        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RequestCommand command = new RequestCommand(get);
            System.out.println(command.execute());
        });
        testStr.remove();

        return get;
    }
}
