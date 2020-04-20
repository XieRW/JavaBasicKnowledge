package com.xierw.design.partterns.behavioralPattern.observer;

/**
 * 观察者接口
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public interface Observer {

    /**
     * 收到通知时更新自己
     * @param message
     */
    public void update(String message);
}
