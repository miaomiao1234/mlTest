package com.example.mlTest.designpatterns.delegate;

/**
 * @author miaoliang
 * @since 6/25/21 9:36 AM
 *
 * 策略模式是一种想法
 */
public class Employee1 implements MLDelegate{
    @Override
    public void doing() {
        System.out.println("用工1开始执行任务。。。");
    }
}
