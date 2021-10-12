package com.tik.mysystem.system.service;

import com.tik.mysystem.system.hystrix.RequestCommand;
import org.apache.dubbo.config.annotation.Service;


public interface HystrixService {

    String getChangeEventData1(String name);

}
