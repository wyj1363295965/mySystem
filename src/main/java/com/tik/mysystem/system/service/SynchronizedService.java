package com.tik.mysystem.system.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SynchronizedService {

    @Async("taskExecutor")
    public CompletableFuture<String> synchronizedMethod(String code) throws InterruptedException {
        //锁住当前方法，只有一个请求执行
//        synchronized (this){
//            Thread.sleep(1000*3);
//            log.info(code);
//            return code;
//        }
        log.info(code + "1111111");
        //锁住当前参数，相同参数只有一个请求执行
        synchronized (code) {
            Thread.sleep(1000 * 3);
            log.info(code);
        }
        log.info("333333");
        return CompletableFuture.completedFuture(code);
    }
}
