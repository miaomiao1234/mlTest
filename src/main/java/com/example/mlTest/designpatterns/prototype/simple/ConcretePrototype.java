package com.example.mlTest.designpatterns.prototype.simple;

import java.util.ArrayList;

/**
 * @author miaoliang
 * @since 6/25/21 1:44 PM
 */
public class ConcretePrototype implements Cloneable {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private ArrayList list = new ArrayList();

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    protected ConcretePrototype clone(){
        ConcretePrototype concretePrototype = null;
        try {
            concretePrototype = (ConcretePrototype) super.clone();
            concretePrototype.list = (ArrayList) list.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return concretePrototype;
    }
}
