package com.xierw.design.partterns.structuralPattern.proxy.dynamicProxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试类
 *
 * 通过Proxy.newProxyInstance()来代理生成具体的被代理类的实例，每个被代理的示例都会有一个与之关联的InvocationHandle实现类，
 * 如果代理的方法被调用，那么代理则会通知和转发给内部的InvocationHandle实现类，由它内部的invoke()去决定怎么处理
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class Main {
    public static void main(String[] args){
        SellWine maoTai = new MaoTai();
        SellWine wuLiangYe = new WuLiangYe();
        SellCigarette fuRongWang = new FuRongWang();

        InvocationHandler shop = new Shop(maoTai);
        InvocationHandler shop2 = new Shop(wuLiangYe);
        InvocationHandler shop3 = new Shop(fuRongWang);

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaoTai.class.getClassLoader(),MaoTai.class.getInterfaces(),shop);
        SellWine dynamicProxy2 = (SellWine) Proxy.newProxyInstance(WuLiangYe.class.getClassLoader(),WuLiangYe.class.getInterfaces(),shop2);
        SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(FuRongWang.class.getClassLoader(),FuRongWang.class.getInterfaces(),shop3);

        dynamicProxy.sellWine();
        dynamicProxy2.sellWine();
        dynamicProxy3.sellCigarette();
    }
}
