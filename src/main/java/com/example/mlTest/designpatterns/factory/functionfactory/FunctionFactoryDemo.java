package com.example.mlTest.designpatterns.factory.functionfactory;

/**
 * @author miaoliang
 * @since 6/24/21 3:00 PM
 *
 * 工厂方法模式
 * 各自产品的生产商都有自己的工厂
 * 生产的工艺，实现程度是不一样的
 * 需要用户关心产品的生产商
 * 增加了代码的使用复杂度
 */
public class FunctionFactoryDemo {
    public static void main(String[] args) {
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar());
        Factory factory1 = new BenzFactory();
        System.out.println(factory1.getCar());
        Factory factory2 = new BMWFactory();
        System.out.println(factory2.getCar());
    }
}
