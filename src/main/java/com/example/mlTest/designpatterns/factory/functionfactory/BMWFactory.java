package com.example.mlTest.designpatterns.factory.functionfactory;

import com.example.mlTest.designpatterns.factory.Car;
import com.example.mlTest.designpatterns.factory.BMW;

/**
 * @author miaoliang
 * @since 6/24/21 2:57 PM
 */
public class BMWFactory implements Factory {
    @Override
    public Car getCar() {
        return new BMW() ;
    }
}
