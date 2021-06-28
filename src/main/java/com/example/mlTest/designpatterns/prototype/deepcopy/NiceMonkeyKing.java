package com.example.mlTest.designpatterns.prototype.deepcopy;

import java.io.*;
import java.util.Date;

/**
 * @author miaoliang
 * @since 6/27/21 2:40 PM
 */
public class NiceMonkeyKing extends Monkey implements Cloneable,Serializable {

    private GoldHoop goldHoop;

    public NiceMonkeyKing(){
        this.goldHoop = new GoldHoop();
        this.setBirthday(new Date());
        this.setHeight(20);
        this.setWeight(5);
    }

    public GoldHoop getGoldHoop() {
        return goldHoop;
    }

    public void setGoldHoop(GoldHoop goldHoop) {
        this.goldHoop = goldHoop;
    }

    public Object cloneMonkey(){
//        return super.clone();  // 默认只支持浅克隆（支持基础数据类型和String类型），
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            NiceMonkeyKing o = (NiceMonkeyKing) ois.readObject();
            o.setBirthday(new Date());
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                bis.close();
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void change(){
        NiceMonkeyKing cloneMonkey = (NiceMonkeyKing) cloneMonkey();
        System.out.println("原始生日："+ this.getBirthday().getTime());
        System.out.println("克隆猴生日："+ cloneMonkey.getBirthday().getTime());
        System.out.println("原始体重："+this.getWeight());
        System.out.println("克隆猴体重："+cloneMonkey.getWeight());
        System.out.println("是否为同一只候："+(this == cloneMonkey));
        System.out.println("是否为同一根棍子："+(this.getGoldHoop() == cloneMonkey.getGoldHoop()));
    }


}
