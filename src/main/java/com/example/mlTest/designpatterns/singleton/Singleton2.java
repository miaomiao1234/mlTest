package com.example.mlTest.designpatterns.singleton;

/**
 * @author miaoliang
 * @since 6/24/21 4:38 PM
 *
 * 2//懒汉式，加同步锁，支持多线程（支持多线程才能使真正意义上的单例）
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    // 对外暴露实例化方法，加锁
    // 懒汉式只有外界调用实例化方法时才做实例化操作
    public static synchronized Singleton2 getInstance(){
        if (null == instance) {
            return new Singleton2();
        }
        return instance;
    }


}
