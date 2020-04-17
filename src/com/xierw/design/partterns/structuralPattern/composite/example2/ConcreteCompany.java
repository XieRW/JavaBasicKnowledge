package com.xierw.design.partterns.structuralPattern.composite.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体公司类，有下级单位，树枝节点
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class ConcreteCompany extends Company {

    public ConcreteCompany(String name,String duty) {
        super(name,duty);
    }

    @Override
    public void add(Company company) {
        this.childrenCompany.add(company);
    }

    @Override
    public void remove(Company company) {
        childrenCompany.remove(company);
    }

}

