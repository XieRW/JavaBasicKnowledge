package com.xierw.design.partterns.creationalPattern.simpleFactoryPattern;

import java.text.DateFormat;
import java.util.Optional;

/**
 * 简单工厂模式--测试简单工厂模式类
 *
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-04-07
 */
public class FactoryTest{

    public static void main(String[] args){
        Car car1 = Factory.createCar(CarEnum.SEDEN.getType(),"SUV");
        car1.use();
        System.out.println("==========分界线==========");

        Car car2 = Factory.createCar(CarEnum.TRUNKS.getType(), "五菱货车");
        car2.use();
        System.out.println("==========分界线==========");

        Car car3 = Factory.createCar("otherCar", "玩具车");
        car3.use();
        System.out.println("==========分界线==========");


        Car car4 = Factory.createCarByReflect(CarEnum.SEDEN.getType(),"SUV");
        car4.use();
        System.out.println("==========分界线==========");

        Car car5 = Factory.createCarByReflect(CarEnum.TRUNKS.getType(), "五菱货车");
        car5.use();
        System.out.println("==========分界线==========");

        Car car6 = Factory.createCarByReflect("otherCar", "玩具车");
        //使用Optional处理空值
        Optional<Car> optionalCar1 = Optional.ofNullable(car6);
        //ifPresent()-->optionalCar1对象为空则不调用其Consumer方法
        optionalCar1.ifPresent(car -> car.use());
        System.out.println("==========分界线==========");
    }

}
