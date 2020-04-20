package com.xierw.design.partterns.structuralPattern.proxy.dynamicProxy.example;

/**
 * 五粮液，拥有销售白酒的许可证
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class FuRongWang implements SellCigarette {

    @Override
    public void sellCigarette() {
        System.out.println("我卖的是正宗的芙蓉王，可以扫描条形码查证！");
    }
}
