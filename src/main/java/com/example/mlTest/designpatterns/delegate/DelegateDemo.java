package com.example.mlTest.designpatterns.delegate;

/**
 * @author miaoliang
 * @since 6/25/21 10:04 AM
 */
public class DelegateDemo {

    public static void main(String[] args) {
        Dispatcher dispatcher1 = new Dispatcher(new Employee1());
        Dispatcher dispatcher2 = new Dispatcher(new Employee2());
        Dispatcher dispatcher3 = new Dispatcher(Employee1::new);
        dispatcher1.doing();
        dispatcher2.doing();
        dispatcher3.doing();
    }

}
