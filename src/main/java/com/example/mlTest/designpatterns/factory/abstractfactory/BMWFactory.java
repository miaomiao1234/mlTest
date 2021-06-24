package com.example.mlTest.designpatterns.factory.abstractfactory;

import com.example.mlTest.designpatterns.factory.BMW;
import com.example.mlTest.designpatterns.factory.Car;
import com.example.mlTest.designpatterns.factory.functionfactory.Factory;

/**
 * @author miaoliang
 * @since 6/24/21 2:57 PM
 */
public class BMWFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BMW() ;
    }
}
