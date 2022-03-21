package com.tik.mysystem.system.service;


import com.tik.mysystem.system.repository.ZhujieDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ZhujieTest {

    @Resource
    private ZhujieDao zhujieDao;
}
