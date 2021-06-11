package com.example.mlTest.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author miaoliang
 * @since 6/6/21 10:43 PM
 *
 * ReadWriteLock可以提高读取效率：
 * ReadWriteLock只允许一个线程写入；
 * ReadWriteLock允许多个线程在没有写入时同时读取；
 * ReadWriteLock适合读多写少的场景。
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sumOfList(list));
        System.out.println(list);

    }
    static int sumOfList(List<? extends Integer> list) {
        int sum = 0;
        for (int i=0; i<list.size(); i++) {
            Integer n = list.get(i);
            list.set(i,null);
            sum = sum + n;
        }
        return sum;
    }
}

class Counter2 {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}
