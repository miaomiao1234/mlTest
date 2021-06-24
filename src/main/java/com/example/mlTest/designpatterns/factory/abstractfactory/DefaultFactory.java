package com.example.mlTest.designpatterns.factory.abstractfactory;

import com.example.mlTest.designpatterns.factory.BMW;
import com.example.mlTest.designpatterns.factory.Car;

/**
 * @author miaoliang
 * @since 6/24/21 2:57 PM
 */
public class DefaultFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BMWFactory().getCar()  ;
    }
}
