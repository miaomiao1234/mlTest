package com.example.mlTest.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author miaoliang
 * @since 6/6/21 10:25 PM
 */
public class ReetrantLockDemo {

}

class Counter1 {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
//        lock.lock();
//        try {
//            count += n;
//        } finally {
//            lock.unlock();
//        }
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)){
                try {
                    count += n;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("一秒钟未获取到锁，放弃吧");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
