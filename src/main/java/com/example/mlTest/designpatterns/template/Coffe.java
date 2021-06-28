package com.example.mlTest.designpatterns.template;

/**
 * @author miaoliang
 * @since 6/27/21 3:50 PM
 */
public class Coffe implements Beverage {

    @Override
    public void addAccessories() {
        System.out.println("添加，牛奶，糖。。。");
    }

    @Override
    public void pourInCup() {
        System.out.println("向杯子中添加咖啡，水。。。");
    }
}
