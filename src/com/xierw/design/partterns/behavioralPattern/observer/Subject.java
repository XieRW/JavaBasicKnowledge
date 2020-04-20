package com.xierw.design.partterns.behavioralPattern.observer;

/**
 * 主题接口
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public interface Subject {

    /**
     * 添加观察者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 发送通知
     * @param message
     */
    void notify(String message);

}
