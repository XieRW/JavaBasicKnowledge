package com.xierw.dataStructure.bloomFilter;

import java.util.BitSet;

/**
 * 测试布隆过滤器
 *
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-03-12
 */
public class demo {

    public static void main(String[] args) {
        String value1 = "http://www.baidu.com";
        String value2 = "https://www.baidu.com";

        MyBloomFilter bloomFilter = new MyBloomFilter();

        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));

        bloomFilter.add(value1);
        bloomFilter.add(value2);

        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));

    }
}
