package com.xierw.design.partterns.structuralPattern.facade;

/**
 * 使用外观模式模式，用Facade来封装所有的内部操作
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class FacadePattern {
    public static void main(String[] args) {

        Light light = new Light();
        Television television = new Television();
        Aircondition aircondition = new Aircondition();

        Facade facade = new Facade(light,television,aircondition);

        /**
         * 起床后一键开电器
         */
        facade.on();
        System.out.println("可以看电视了");

        System.out.println("");

        /**
         * 睡觉时一键关电器
         */
        facade.off();
        System.out.println("可以睡觉了");
    }
}
