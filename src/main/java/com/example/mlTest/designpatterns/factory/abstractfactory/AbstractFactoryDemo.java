package com.example.mlTest.designpatterns.factory.abstractfactory;

/**
 * @author miaoliang
 * @since 6/24/21 3:17 PM
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println(new DefaultFactory().getCar("audi"));
    }
}
