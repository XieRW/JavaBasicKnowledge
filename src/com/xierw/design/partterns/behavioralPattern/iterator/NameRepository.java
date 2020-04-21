package com.xierw.design.partterns.behavioralPattern.iterator;

import java.util.Iterator;

/**
 * 实体类，实现了Container容器
 *
 * @date 2020-04-21
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora"};

    /**
     * 获取一个迭代器
     * @return
     */
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    /**
     * 定义一个内部类，实现Iterator方法，定义迭代器的实现规则
     */
    public class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()){
                // index++   ->>  先返回name[index],然后再index = index+1
                return names[index++];
            }
            return null;
        }
    }
}
