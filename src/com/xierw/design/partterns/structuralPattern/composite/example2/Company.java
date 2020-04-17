package com.xierw.design.partterns.structuralPattern.composite.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司或部门
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public abstract class Company {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    protected String duty;

    protected List<Company> childrenCompany = new ArrayList<Company>();

    /**
     * 验证java的值传递
     * @param c Company
     */
    public void setCompanyName(Company c){
        c.setName("newName");
        c = new ConcreteCompany("新的分公司","负责管理下级单位");
    }

    public Company(String name,String duty){
        this.name = name;
        this.duty = duty;
    }

    /**
     * add
     * @param company
     */
    public abstract void add(Company company);

    /**
     * remove
     * @param company
     */
    public abstract void remove(Company company);

    /**
     * 打印详情
     * @param depth
     */
    public void display(int depth){
        System.out.println("第 " + depth + " 层的机构名为： " + name);
        for (Company c : childrenCompany) {
            c.display(depth + 1);
        }
    }

    /**
     * 职责
     */
    public void lineofDuty(){
        System.out.println(name + " 的职责为： " + duty);
        for (Company c : childrenCompany) {
            c.lineofDuty();
        }
    }

}

