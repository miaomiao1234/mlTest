package com.example.mlTest.designpatterns.template;

/**
 * @author miaoliang
 * @since 6/27/21 3:44 PM
 */
public interface  Beverage {

    // 不能再被重写
    public default void create(){
        // 烧开水
        boiledWater();
        // 准备杯子，并放入原料
        pourInCup();
        // 用水冲泡
        brew();
        // 添加辅料
        addAccessories();
    }

     void addAccessories();

    default void brew(){
        System.out.println("开水冲泡。。。");
    };

    abstract void pourInCup();

    default void boiledWater(){
        System.out.println("点火烧水至100度。。。");
    };
    


}
