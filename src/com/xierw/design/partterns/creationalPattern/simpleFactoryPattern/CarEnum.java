package com.xierw.design.partterns.creationalPattern.simpleFactoryPattern;

/**
 * 简单工厂模式--实际工厂枚举
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-04-07
 */
public enum CarEnum {

    /**
     * 轿车
     */
    SEDEN("com.xierw.design.partterns.simpleFactoryPattern.Sedan"),
    /**
     * 货车
     */
    TRUNKS("com.xierw.design.partterns.simpleFactoryPattern.Trucks");

    private String type;

    CarEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
