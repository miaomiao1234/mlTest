package com.example.mlTest.designpatterns.factory.functionfactory;

import com.example.mlTest.designpatterns.factory.Car;

/**
 * @author miaoliang
 * @since 6/24/21 2:55 PM
 *
 * 工厂的接口就定义了工厂的执行标准
 */
public interface Factory {

    Car getCar();

}
