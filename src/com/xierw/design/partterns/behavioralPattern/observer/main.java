package com.xierw.design.partterns.behavioralPattern.observer;

/**
 * 测试类，测试观察者模式的实现
 *
 * 主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class main {

    public static void main(String[] args){
        Subject subject = new ConcreteSubject();
        // 创建微信用户
        Observer user1 = new ConcreteObserver("孙悟空");
        Observer user2 = new ConcreteObserver("猪八戒");
        Observer user3 = new ConcreteObserver("沙和尚");
        // 订阅了师傅的消息
        subject.attach(user1);
        subject.attach(user2);
        subject.attach(user3);
        // 师傅发出求救信号
        subject.notify("师傅被妖怪抓走了！！！");
    }
}
