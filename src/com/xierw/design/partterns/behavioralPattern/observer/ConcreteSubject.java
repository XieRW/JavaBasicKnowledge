package com.xierw.design.partterns.behavioralPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题类
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class ConcreteSubject implements Subject {

    /**
     * 观察者队列
     */
    List<Observer> weiXinUsers = new ArrayList<Observer>();

    /**
     * 添加观察者
     * @param observer
     */
    @Override
    public void attach(Observer observer) {
        if (!weiXinUsers.contains(observer)){
            weiXinUsers.add(observer);
        }
    }

    /**
     * 删除观察者
     * @param observer
     */
    @Override
    public void detach(Observer observer) {
        if (weiXinUsers.contains(observer)){
            weiXinUsers.remove(observer);
        }
    }

    /**
     * 发送通知
     * @param message
     */
    @Override
    public void notify(String message) {
        for (Observer observer:weiXinUsers){
            observer.update(message);
        }
    }
}
