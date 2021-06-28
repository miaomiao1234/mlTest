package com.example.mlTest.designpatterns.template;

/**
 * @author miaoliang
 * @since 6/27/21 3:50 PM
 */
public class Tea implements Beverage {

    @Override
    public void addAccessories() {
        System.out.println("盖上杯盖。。。");
    }

    @Override
    public void pourInCup() {
        System.out.println("向杯子中添加茶叶，水。。。");
    }
}
