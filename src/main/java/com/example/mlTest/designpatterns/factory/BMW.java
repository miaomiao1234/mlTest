package com.example.mlTest.designpatterns.factory;

import com.example.mlTest.designpatterns.factory.Car;

/**
 * @author miaoliang
 * @since 6/24/21 2:10 PM
 */
public class BMW implements Car {
    @Override
    public String getName() {
        return "BMW";
    }
}
