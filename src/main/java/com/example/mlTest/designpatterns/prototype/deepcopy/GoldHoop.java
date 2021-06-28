package com.example.mlTest.designpatterns.prototype.deepcopy;

import java.io.Serializable;

/**
 * @author miaoliang
 * @since 6/27/21 2:42 PM
 */
public class GoldHoop implements Serializable {

    private float height = 100;

    private float diameter = 100;

    // 变大方法
    public void growUp(){
        this.height *= 2;
        this.diameter *= 2;
    }

    // 变小
    public void shrink(){
        this.height /= 2;
        this.diameter /= 2;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }
}
