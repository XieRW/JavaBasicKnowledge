package com.xierw.design.partterns.structuralPattern.facade;

/**
 * 遥控器，封装灯、电视、遥控器这些对象的操作，给用户提供一个简单的操作类
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class Facade {

    private Light light;
    private Television television;
    private Aircondition aircondition;

    /**
     * 构造函数
     * @param light 灯
     * @param television 电视
     * @param aircondition 空调
     */
    public Facade(Light light, Television television, Aircondition aircondition) {
        this.light = light;
        this.television = television;
        this.aircondition = aircondition;

    }

    //起床后一键开电器
    public void on() {
        System.out.println("起床了");
        light.on();
        television.on();
        aircondition.on();

    }

    //睡觉时一键关电器
    public void off() {
        System.out.println("睡觉了");
        light.off();
        television.off();
        aircondition.off();
    }
}


