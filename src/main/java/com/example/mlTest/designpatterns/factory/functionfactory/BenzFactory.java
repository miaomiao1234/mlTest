package com.example.mlTest.designpatterns.factory.functionfactory;

import com.example.mlTest.designpatterns.factory.Car;
import com.example.mlTest.designpatterns.factory.Benz;

/**
 * @author miaoliang
 * @since 6/24/21 2:57 PM
 */
public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
