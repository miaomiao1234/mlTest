package com.example.mlTest.designpatterns.factory.abstractfactory;

import com.example.mlTest.designpatterns.factory.Benz;
import com.example.mlTest.designpatterns.factory.Car;
import com.example.mlTest.designpatterns.factory.functionfactory.Factory;

/**
 * @author miaoliang
 * @since 6/24/21 2:57 PM
 */
public class BenzFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
