package com.xierw.design.partterns.behavioralPattern.iterator;

import java.util.Iterator;

/**
 * 测试类，实现了迭代器模式
 *
 * @date 2020-04-21
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class IteratorPatternDemo {

    public static void main(String[] args){
        NameRepository nameRepository = new NameRepository();
        for (Iterator iterator = nameRepository.getIterator();iterator.hasNext();){
            String name = (String) iterator.next();
            System.out.println("name:" + name);
        }
    }
}
