package com.example.mlTest.designpatterns.factory.abstractfactory;

import com.example.mlTest.designpatterns.factory.Audi;
import com.example.mlTest.designpatterns.factory.Car;
import com.example.mlTest.designpatterns.factory.functionfactory.Factory;

/**
 * @author miaoliang
 * @since 6/24/21 2:57 PM
 */
public class AudiFactory extends AbstractFactory {
    @Override
    protected Car getCar() {
        return new Audi();
    }
}
