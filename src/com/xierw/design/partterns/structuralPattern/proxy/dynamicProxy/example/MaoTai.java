package com.xierw.design.partterns.structuralPattern.proxy.dynamicProxy.example;

/**
 * 茅台酒，拥有销售白酒的许可证
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class MaoTai implements SellWine {

    @Override
    public void sellWine() {
        System.out.println("我卖的是茅台酒！");
    }
}
