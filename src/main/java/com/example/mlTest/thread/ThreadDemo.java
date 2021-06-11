package com.example.mlTest.thread;

/**
 * @author miaoliang
 * @since 6/6/21 9:19 PM
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized (Counter.lock){
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized (Counter.lock){
                Counter.count -= 1;
            }
        }
    }
}