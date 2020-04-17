package com.xierw.design.partterns.structuralPattern.composite.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司员工情况
 *
 * @date 2020-04-17
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class Employee {

    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工职位
     */
    private String dept;
    /**
     * 员工薪水
     */
    private int salary;
    /**
     * 员工的部下
     */
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary, List<Employee> subordinates){
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = subordinates;
    }

    public Employee(String name, String dept, int salary){
        this(name,dept,salary,new ArrayList<Employee>());
    }

    public void add(Employee d){
        subordinates.add(d);
    }

    public void remove(Employee d){
        subordinates.remove(d);
    }

    public List<Employee> getSubordinates(){
        return this.subordinates;
    }

    /**
     * 递归遍历所有下属员工，并打印其详情
     */
    public void pringtOrganization(){
        System.out.println(this.toString());
        for (Employee e:subordinates){
            e.pringtOrganization();
        }
    }

    /**
     * 重写toString()
     *
     * @return 不返回subordinate集合
     */
    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
