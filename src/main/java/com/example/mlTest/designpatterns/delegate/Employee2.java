package com.example.mlTest.designpatterns.delegate;

/**
 * @author miaoliang
 * @since 6/25/21 9:36 AM
 */
public class Employee2 implements MLDelegate{
    @Override
    public void doing() {
        System.out.println("员工2开始执行任务...");
    }
}
