package com.tik.mysystem.system.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

@Service
public class ThreadPoolService {

    @Async("taskExecutor")
    public void tesTask1(int i) {
        System.out.println(Thread.currentThread().getName() + "-----" + i);
    }

    @Async("taskExecutor")
    public Future<Integer> tesTask2(int i, CountDownLatch latch) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "-----" + i);
        Thread.sleep(2000);
        latch.countDown();
        return new AsyncResult<>(i);
    }
}
