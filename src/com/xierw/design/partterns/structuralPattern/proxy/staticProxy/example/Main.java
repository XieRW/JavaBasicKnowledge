package com.xierw.design.partterns.structuralPattern.proxy.staticProxy.example;

import java.util.Date;

/**
 * 用户类，使用代理类封装数据库查询类后，模拟系统的启动过程
 *
 * 若系统不使用代理模式，则在启动时就要初始化 DBQuery 对象，而使用代理模式后，启动时只需要初始化一个轻量级的对象 DBQueryProxy
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
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
