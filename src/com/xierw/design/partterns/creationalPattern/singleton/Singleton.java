package com.xierw.design.partterns.creationalPattern.singleton;

/**
 * 双重检查锁实现线程安全式的懒汉单例模式
 *
 * 创建一个私有的构造方法，避免外部创建类的示例；然后定义一个静态的类的实例，外部通过getUniqueInstance获取此静态示例，以此实现单例；用双重检查锁保证线程安全。
 *
 * 另外，需要注意 uniqueInstance 采用 volatile 关键字修饰也是很有必要。
 *
 * uniqueInstance 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
 *
 * 1.为 uniqueInstance 分配内存空间
 * 2.初始化 uniqueInstance
 * 3.将 uniqueInstance 指向分配的内存地址
 * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
 *
 * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 * ————————————————
 * 版权声明：本文为CSDN博主「谢小鱼」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_26356861/article/details/104943927
 *
 * @date 2020-04-20
 * @author xieRW 谢小鱼
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
