package com.example.mlTest.designpatterns.template;

/**
 * @author miaoliang
 * @since 6/27/21 3:57 PM
 */
public class BeverageDemo {
    public static void main(String[] args) {
        new Tea().create();
        new Coffe().create();
    }
}
