package com.example.mlTest.designpatterns.factory.simplefactory;

import com.example.mlTest.designpatterns.factory.Audi;
import com.example.mlTest.designpatterns.factory.BMW;
import com.example.mlTest.designpatterns.factory.Benz;
import com.example.mlTest.designpatterns.factory.Car;

/**
 * @author miaoliang
 * @since 6/24/21 2:12 PM
 */
public class SimpleFactory {

    // 实现统一管理、专业化管理（减少管理难度）
    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)){
            return new BMW();
        } if ("Benz".equalsIgnoreCase(name)){
            return new Benz();
        }if ("Audi".equalsIgnoreCase(name)){
            return new Audi();
        } else {
            return new Audi();
        }
    }

}
