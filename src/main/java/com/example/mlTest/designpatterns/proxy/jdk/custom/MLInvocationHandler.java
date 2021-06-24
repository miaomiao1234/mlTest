package com.example.mlTest.designpatterns.proxy.jdk.custom;

import java.lang.reflect.Method;

/**
 * @author miaoliang
 * @since 6/22/21 4:17 PM
 */
public interface MLInvocationHandler {
    Object invoke(Object var1, Method var2, Object[] var3) throws Throwable;
}
