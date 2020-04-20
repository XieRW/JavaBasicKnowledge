package com.xierw.design.partterns.structuralPattern.proxy.staticProxy.example;

/**
 * 实际的数据查询类
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class DBQuery implements IDBQuery {

    public DBQuery(){
        try {
            // 假设连接数据库等耗时操作
            Thread.sleep(1000);
            System.out.println("连接数据库成功");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        System.out.println("request SUCCESS!");
        return "request SUCCESS!";
    }
}
