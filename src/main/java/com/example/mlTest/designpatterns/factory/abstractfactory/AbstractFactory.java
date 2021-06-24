package com.example.mlTest.designpatterns.factory.abstractfactory;

import com.example.mlTest.designpatterns.factory.Car;

/**
 * @author miaoliang
 * @since 6/24/21 3:06 PM
 */
public abstract class AbstractFactory {

    abstract Car getCar();

    public Car getCar(String name){
        if ("BMW".equalsIgnoreCase(name)){
            return new BMWFactory().getCar();
        } if ("Benz".equalsIgnoreCase(name)){
            return new BenzFactory().getCar();
        }if ("Audi".equalsIgnoreCase(name)){
            return new AudiFactory().getCar();
        } else {
            return new DefaultFactory().getCar();
        }
    }

}
