package com.example.mlTest.designpatterns.singleton;

/**
 * @author miaoliang
 * @since 6/24/21 4:50 PM
 *
 * 4//双重锁、双重校验锁，（多线程下保持高性能）
 * 先获取singleton对象，如果没有给类枷锁，保证多线程的类的唯一性，然后在确定一次是否有该对象，没有就创建对象。
 */
public class Singleton4 {

    // volatile 保证多线程下内存可见性
    private volatile static Singleton4 instance;

    private Singleton4(){}

    public Singleton4 getInstance(){
        if (null == instance) {
            synchronized (Singleton4.class) {
                if (null == instance) {
                    return new Singleton4();
                }
            }
        }
        return instance;
    }



}
