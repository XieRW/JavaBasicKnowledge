package com.xierw.dataStructure.bloomFilter;

import java.util.BitSet;

/**
 * java实现布隆过滤器检查重复
 *
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-03-12
 */
public class MyBloomFilter {

    /**
     * 位数组的大小
     */
    private static final int DEFAULT_SIZE = 2 << 24;
    /**
     * 通过这个数组可以创建 6 个不同的哈希函数
     */
    private static final int[] SEEDS = new int[]{3,16,47,75,98,142};
    /**
     * 位数组。数组中的元素只能是 0 或者 1
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    /**
     * 存放包含 hash 函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];
    /**
     * 初始化多个包含 hash 函数的类的数组，每个类中的 hash 函数都不一样
     */
    public MyBloomFilter(){
        for (int i=0;i<SEEDS.length;i++){
            func[i] = new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }
    /**
     * 添加元素到位数组
     */
    public void add(Object value){
        boolean ret = true;
        for (SimpleHash f : func){
            bits.set(f.hash(value),true);
        }
    }
    /**
     * 判断指定元素是否存在于位数组
     */
    public boolean contains(Object value){
        boolean ret = true;
        for (SimpleHash f : func){
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }
    /**
     * 静态内部类。用于 hash 操作！
     */
    private static class SimpleHash{
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }
        /**
         * 计算 hash 值
         */
        public int hash(Object value){
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & (value.hashCode() ^ (value.hashCode() >>> 16)));
        }
    }
}
