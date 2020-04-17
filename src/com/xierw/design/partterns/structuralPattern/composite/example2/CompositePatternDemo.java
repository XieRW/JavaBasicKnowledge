package com.xierw.design.partterns.structuralPattern.composite.example2;

/**
 * 组合模式
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class CompositePatternDemo {

    public static void main(String[] args) {

        //一个总公司
        ConcreteCompany root = new ConcreteCompany("北京总公司","负责管理下级单位");
        root.add(new HRDepartment("总公司人力资源部","负责员工招聘管理培训"));
        root.add(new FinanceDepartment("总公司财务部","负责公司财务收支管理"));

        //三个子公司
        ConcreteCompany com1 = new ConcreteCompany("广州分公司","负责管理下级单位");
        com1.add(new HRDepartment("广州分公司人力资源部","负责员工招聘管理培训"));
        com1.add(new FinanceDepartment("广州分公司财务部","负责公司财务收支管理"));
        root.add(com1);

        ConcreteCompany com2 = new ConcreteCompany("杭州分公司","负责管理下级单位");
        com2.add(new HRDepartment("杭州分公司人力资源部","负责员工招聘管理培训"));
        com2.add(new FinanceDepartment("杭州分公司财务部","负责公司财务收支管理"));
        root.add(com2);

        ConcreteCompany com3 = new ConcreteCompany("深圳分公司","负责管理下级单位");
        com3.add(new HRDepartment("深圳分公司人力资源部","负责员工招聘管理培训"));
        com3.add(new FinanceDepartment("深圳分公司财务部","负责公司财务收支管理"));
        root.add(com3);

        System.out.println("-------公司结构图--------");
        root.display(1);
        System.out.println("----------各部门职责----------");
        root.lineofDuty();

        /**
         * 验证java的值传递
         * @param c Company
         */
        root.setCompanyName(com1);
        System.out.println(com1.name);

    }

}

