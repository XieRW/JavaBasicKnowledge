package com.xierw.multithreading;

import java.util.Date;

public class MyRunnable implements Runnable{
    private String command;
    public MyRunnable(String s){
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start Time:"+new Date()+" Command:"+this.toString());
        processCommond();
        System.out.println(Thread.currentThread().getName()+" End Time:"+new Date()+" Command:"+this.toString());
    }

    private void processCommond(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }

}
