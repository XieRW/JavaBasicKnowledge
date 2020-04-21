package com.xierw.design.partterns.behavioralPattern.iterator;

import java.util.Iterator;

/**
 * 容器接口，定义了需要实现哪种迭代器
 *
 * @date 2020-04-21
 * @author xieRW
 * @email 1429382875@qq.com
 */
public interface Container {

    /**
     * 获取一个迭代器
     * @return
     */
    Iterator getIterator();
}
