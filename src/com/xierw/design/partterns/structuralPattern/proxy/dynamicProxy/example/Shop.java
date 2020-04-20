package com.xierw.design.partterns.structuralPattern.proxy.dynamicProxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler接口，并重写invoke()方法来调用具体代理类的方法
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class Shop implements InvocationHandler {

    Object object;

    public Shop(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始     商铺是：" + this.getClass().getSimpleName());
        method.invoke(object,args);
        System.out.println("销售结束！");
        return null;
    }
}
