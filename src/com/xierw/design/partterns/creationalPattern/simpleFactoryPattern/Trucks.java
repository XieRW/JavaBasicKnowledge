package com.xierw.design.partterns.creationalPattern.simpleFactoryPattern;

/**
 * 简单工厂模式--实际工厂类
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-04-07
 */
public class Trucks extends Car {

    public Trucks(String name){
        this.name = name;
    }

    @Override
    public void use(){
        System.out.println("我可以用来拉货！");
        System.out.println("我的名字是："+name);
    }
}
