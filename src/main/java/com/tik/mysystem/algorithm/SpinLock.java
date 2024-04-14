package com.tik.mysystem.algorithm;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 自旋锁
 */
public class SpinLock {

    private AtomicBoolean atomicBoolean = new AtomicBoolean();

    public void lock() {
        while (!atomicBoolean.compareAndSet(false, true)) {
            //自旋
        }
    }

    public void unlock() {
        atomicBoolean.set(false);
    }
}
