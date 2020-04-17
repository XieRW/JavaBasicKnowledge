package com.xierw.design.partterns.structuralPattern.composite.example2;

/**
 * 财务部（树叶节点）
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class FinanceDepartment extends Company {

    public FinanceDepartment(String name,String duty) {
        super(name,duty);
    }

    @Override
    public void add(Company company) {

    }


    @Override
    public void remove(Company company) {

    }

}

