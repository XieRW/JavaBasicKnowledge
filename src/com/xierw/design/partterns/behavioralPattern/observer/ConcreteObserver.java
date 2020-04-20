package com.xierw.design.partterns.behavioralPattern.observer;

/**
 * 具体观察者类
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class ConcreteObserver implements Observer {

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 构造函数
     * @param name
     */
    public ConcreteObserver(String name){
        this.name = name;
    }

    /**
     * 收到通知时更新自己
     * @param message
     */
    @Override
    public void update(String message) {
        System.out.println("“" + name + "”收到了消息：" + message);
    }
}
