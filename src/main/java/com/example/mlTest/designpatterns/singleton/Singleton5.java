package com.example.mlTest.designpatterns.singleton;

/**
 * @author miaoliang
 * @since 6/24/21 5:02 PM
 *
 * 5//登记式/静态内部类 (效果同3饿汉式，只是多了懒加载效果)
 */
public class Singleton5 {

    private static class Singletonhelper{

        private static Singleton5 instance = new Singleton5();
    }

    private Singleton5(){}

    // final为了防止内部操作
    public static final Singleton5 getInstance(){
        return Singletonhelper.instance;
    }

}
