package com.xierw.design.partterns.simpleFactoryPattern;

/**
 * 简单工厂模式--实际工厂枚举
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-04-07
 */
public enum CarEnum {

    SEDEN("com.xierw.design.partterns.simpleFactoryPattern.Sedan"),
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
