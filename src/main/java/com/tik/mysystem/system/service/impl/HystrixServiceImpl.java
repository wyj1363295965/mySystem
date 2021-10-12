package com.tik.mysystem.system.service.impl;

import com.tik.mysystem.system.hystrix.RequestCommand;
import com.tik.mysystem.system.service.HystrixService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HystrixServiceImpl implements HystrixService {

    public String getChangeEventData1(String name) {
        RequestCommand command = new RequestCommand(name);
        return command.execute();
    }
}
