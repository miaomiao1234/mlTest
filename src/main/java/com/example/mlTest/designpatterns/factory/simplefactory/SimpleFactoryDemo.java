package com.example.mlTest.designpatterns.factory.simplefactory;

/**
 * @author miaoliang
 * @since 6/24/21 2:12 PM
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        // 消费者
        System.out.println(new SimpleFactory().getCar("BMW").getName());
    }

}
