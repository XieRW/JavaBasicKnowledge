package com.xierw.design.partterns.simpleFactoryPattern;

/**
 * 简单工厂模式--抽象工厂类
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-04-07
 */
public abstract class Car {

    /**
     * 车的名字
     */
    String name;

    public Car(String name) {
        this.name=name;
    }

    /**
     * 无参构造函数的意义在于子类调用其构造方法时，默认先调用父类的无参构造方法
     */
    public Car(){}

    abstract void use();


}
