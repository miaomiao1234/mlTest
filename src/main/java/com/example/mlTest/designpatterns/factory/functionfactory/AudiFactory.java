package com.example.mlTest.designpatterns.factory.functionfactory;

import com.example.mlTest.designpatterns.factory.Car;
import com.example.mlTest.designpatterns.factory.Audi;

/**
 * @author miaoliang
 * @since 6/24/21 2:57 PM
 */
public class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
