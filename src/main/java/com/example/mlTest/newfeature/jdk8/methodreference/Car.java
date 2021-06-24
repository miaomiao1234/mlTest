package com.example.mlTest.newfeature.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author miaoliang
 * @since 6/1/21 9:42 AM
 * <p>
 * 方法引用：
 * <p>
 * 方法引用通过方法的名字来指向一个方法。
 * <p>
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 * <p>
 * 方法引用使用一对冒号 ::
 */

//@FunctionalInterface
//public interface Supplier<T> {
//        T get();
//}

public class Car {

    private String name;


    // Supplier 是jdk 1.8 的接口，这里和lambda一起使用
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void collide(final Car car) {
        System.out.println("Collide:" + car.toString());
    }

    public void follow(final Car annother) {
        System.out.println("Following the " + annother.toString());
    }

    public void repair() {
        System.out.println("Repaired:" + this.toString());
    }

    public static void main(String[] args) {

        // 构造器引用: 它的语法是Class::new，或者更一般的Class< T >::new
        Car car = Car.create(Car::new);
        Car car1 = Car.create(Car::new);
        Car car2 = Car.create(Car::new);
        car.setName("aa");
        car1.setName("bb");
        car2.setName("cc");
        List<Car> cars = Arrays.asList(car, car1, car2);
        List<String> names = Arrays.asList(car.getName(), car1.name, car2.name);
        Car car3 = new Car();
        car3.setName("dd");
        System.out.println(car3.name);
        System.out.println(car3.getName());

        // 静态方法引用：它的语法是Class::static_method
        cars.forEach(Car::collide);
        // 特定类的任意对象的方法引用：它的语法是Class::method
        cars.forEach(Car::repair);
        // 特定对象的方法引用：它的语法是instance::method
        cars.forEach(car::follow);

        names.forEach(System.out::println);
        System.out.println("..................");
        cars.forEach(s->{
            System.out.println(s.getName());
        });


    }

}
