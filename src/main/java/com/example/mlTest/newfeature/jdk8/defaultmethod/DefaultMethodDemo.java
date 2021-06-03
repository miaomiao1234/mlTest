package com.example.mlTest.newfeature.jdk8.defaultmethod;

/**
 * @author miaoliang
 * @since 6/2/21 10:56 AM
 *
 * 定义：
 *  1. 接口可以有实现方法，不需要实现类去实现该方法
 *  2. 只需在方法名前添加一个 default 关键字即可
 *
 *  存在的意义：
 *      1. 方便扩展已有接口（之前的接口是个双刃剑，好处是面向抽象而不是具体的编程，缺陷是修改接口的时候需要修改全部实现该接口的类）
 *          如果没有默认方法，给 JDK 的某个接口添加了一个抽象方法，这个接口的所有实现类都需要修改
 *          如: Iterable 接口添加了 forEach 默认方法，所有其他实现了 Iterable 接口的实现类都可以使用 forEach 方法
 *
 *   重写override 方法
 *      1. 如果子类没有重写父接口默认方法的话，会直接继承父接口默认方法的实现；
 *      2. 如果子类重写父接口默认方法为普通方法，则与普通方法的重写类似；
 *      3. 如果子类（接口或抽象类）重写父接口默认方法为抽象方法，那么所有子类的子类需要实现该方法；
 *
 *   关于默认方法调用冲突
 *      1. 如果子类覆盖了父类的默认方法，直接使用调用子类覆盖后的方法
 *      2. 优先选择更加具体的接口默认方法（更加子类）
 *      3. 如果 C 类同时实现了 A1，A2接口，且A1,A2接口都有相同的默认方法，那么C类会报错
 *          解决方法:
 *              （1） C 类重写默认方法
 *              （2） 指定 父接口中的一个
 */
public class DefaultMethodDemo {

    public static void main(String[] args) {
        FourWheeler car = new Car();
        car.print();
    }
}

interface Vehicle{
    default void print(){
        System.out.println("我是一辆车");
    }

    static void blowHorn(){
        System.out.println("按喇叭");
    }
}

interface FourWheeler{
    default void print(){
        System.out.println("我是一辆四轮车");
    }
}

class Car implements Vehicle,FourWheeler{

    @Override
    public void print() {
        Vehicle.super.print();
    }
}