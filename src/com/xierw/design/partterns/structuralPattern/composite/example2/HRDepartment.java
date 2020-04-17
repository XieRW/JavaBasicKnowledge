package com.xierw.design.partterns.structuralPattern.composite.example2;

/**
 * 人力资源部（树叶节点）
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class HRDepartment extends Company {

    public HRDepartment(String name,String duty) {
        super(name,duty);
    }

    @Override
    public void add(Company company) {
        this.childrenCompany.add(company);
    }

    @Override
    public void remove(Company company) {

    }

}

