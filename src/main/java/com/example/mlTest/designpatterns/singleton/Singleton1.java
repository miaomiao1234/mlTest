package com.example.mlTest.designpatterns.singleton;

/**
 * @author miaoliang
 * @since 6/24/21 4:34 PM
 *
 * 1//懒汉式不加锁，不支持多线程
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1(){}

    // 对外暴露实例化方法
    // 懒汉式只有外界调用实例化方法时才做实例化操作
    public static Singleton1 getInstance(){
        if (null == instance){
            return new Singleton1();
        }
        return instance;
    }
}
