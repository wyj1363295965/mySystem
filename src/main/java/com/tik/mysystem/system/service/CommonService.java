package com.tik.mysystem.system.service;


import com.tik.mysystem.system.repository.ZhujieDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class CommonService {

    @Resource
    private ZhujieDao zhujieDao;

    @Transactional(rollbackFor = Exception.class)
    public void affairTest() {
        log.info("开始事务");
        throw new RuntimeException();
    }
}
