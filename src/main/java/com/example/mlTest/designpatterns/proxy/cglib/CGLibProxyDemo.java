package com.example.mlTest.designpatterns.proxy.cglib;

/**
 * @author miaoliang
 * @since 6/24/21 9:54 AM
 */
public class CGLibProxyDemo {
    public static void main(String[] args) {
        MatchMackerc matchMackerc = new MatchMackerc();
        MLc instance = (MLc)matchMackerc.getInstance(MLc.class);
        instance.getCompanion();
    }
}
