package com.xierw.design.partterns.structuralPattern.proxy.staticProxy.example;

import java.util.Date;

public class Main {

    public static void main(String[] args){
        // 使用代理
        System.out.println(new Date());
        IDBQuery dbquery = new DBQueryProxy();
        System.out.println(new Date());

        // 在真正使用时才创建对象
        dbquery.request();
        System.out.println(new Date());

    }
}
