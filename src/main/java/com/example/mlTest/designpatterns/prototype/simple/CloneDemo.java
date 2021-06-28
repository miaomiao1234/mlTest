package com.example.mlTest.designpatterns.prototype.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaoliang
 * @since 6/25/21 1:45 PM
 */
public class CloneDemo {

    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);
        ArrayList list = new ArrayList();
        list.add(123);
        cp.setList(list);
        ConcretePrototype clone = (ConcretePrototype) cp.clone();
        System.out.println(clone.getAge());
        System.out.println(clone.getList());
        System.out.println(cp.getList());
        System.out.println(cp.getList() == clone.getList());
    }

}
