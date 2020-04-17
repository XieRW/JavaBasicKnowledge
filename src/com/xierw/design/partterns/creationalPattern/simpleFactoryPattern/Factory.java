package com.xierw.design.partterns.creationalPattern.simpleFactoryPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 简单工厂模式--工厂类（基本实现和基于反射机制的优化）
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-04-07
 */
public class Factory {

    public static Car createCar(String type,String name){
        if (type.equals(CarEnum.SEDEN.getType())){
            return new Sedan(name);
        }else if (type.equals(CarEnum.TRUNKS.getType())){
            return new Trucks(name);
        }else {
            return new Car(name) {
                @Override
                void use() {
                    System.out.println("我可以用来驾驶！");
                    System.out.println("我的名字是："+name);
                }
            };
        }
    }

    /**
     * 使用反射机制来改造简单工厂类，可以优化简单工厂模式不易扩展实现类的缺点
     * @param type
     * @param name
     * @return
     */
    public static Car createCarByReflect(String type,String name){
        try {
            Class clazz = Class.forName(type);
            Constructor constructor = clazz.getConstructor(String.class);
            return (Car)constructor.newInstance(name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            return new Car(name) {
                @Override
                void use() {
                    System.out.println("我可以用来驾驶！");
                    System.out.println("我的名字是："+name);
                }
            };
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
