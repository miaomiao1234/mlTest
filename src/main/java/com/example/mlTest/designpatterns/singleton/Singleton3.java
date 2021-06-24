package com.example.mlTest.designpatterns.singleton;

/**
 * @author miaoliang
 * @since 6/24/21 4:44 PM
 *
 * 3//饿汉式
 */
public class Singleton3 {

    // 饿汉式直接在类加载的时候常见实例
    private static Singleton3 instance = new Singleton3();

    private Singleton3(){}

    public static Singleton3 getInstance(){
        return instance;
    }

}
