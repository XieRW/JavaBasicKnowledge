package com.xierw.design.partterns.structuralPattern.proxy.staticProxy.example;

/**
 * 数据查询类的代理类
 *
 * @date 2020-04-20
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class DBQueryProxy implements IDBQuery {

    // 初始一个空的IDBQuery对线
    private IDBQuery dbQuery = null;

    @Override
    public String request() {
        // 在多线程环境下，这里可以用双重检查锁，避免产生多个DBQuery对线
        if (dbQuery == null){
            dbQuery = new DBQuery();
        }
        return dbQuery.request();
    }
}
