package com.xierw.design.partterns.structuralPattern.composite.example1;

/**
 * 使用组合模式，用Employee来创建和打印员工的层次结构
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class CompositePatternDemo {

    public static void main(String[] args){
        Employee CEO = new Employee("唐三藏","CEO",30000);
        Employee headEngineer = new Employee("孙悟空","headMarket",20000);
        Employee headMarket = new Employee("猪八戒","headMarket",18000);
        Employee headLogistics = new Employee("沙悟净","headLogistics",16000);
        Employee engineer1 = new Employee("工程师1","engineer1",8400);
        Employee engineer2 = new Employee("工程师2","engineer2",8600);
        Employee engineer3 = new Employee("工程师3","engineer3",8500);
        Employee market1 = new Employee("销售1","market1",7500);
        Employee market2 = new Employee("销售2","market2",7600);
        Employee logistics = new Employee("后勤","logistics",6800);

        CEO.add(headEngineer);
        CEO.add(headMarket);
        CEO.add(headLogistics);
        headEngineer.add(engineer1);
        headEngineer.add(engineer2);
        headEngineer.add(engineer3);
        headMarket.add(market1);
        headMarket.add(market2);
        headLogistics.add(logistics);

        System.out.println("-------------------公司员工情况----------------------");
        CEO.pringtOrganization();
    }
}
