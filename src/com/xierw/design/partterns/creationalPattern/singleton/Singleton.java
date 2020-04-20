package com.xierw.design.partterns.creationalPattern.singleton;

/**
 * 双重检查锁实现线程安全式的懒汉单例模式
 *
 * 创建一个私有的构造方法，避免外部创建类的示例；然后定义一个静态的类的实例，外部通过getUniqueInstance获取此静态示例，以此实现单例；用双重检查锁保证线程安全。
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
