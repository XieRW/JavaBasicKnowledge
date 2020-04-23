package com.xierw.design.partterns.behavioralPattern.command.example1;

import java.util.Stack;

/**
 * 命令历史
 *
 * @date 2020-04-23
 * @author xie
 * @email 1429382875@qq.com
 */
public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    /**
     * 压入
     * @param c
     */
    public void push(Command c){
        history.push(c);
    }

    /**
     * 抛出
     * @return
     */
    public Command pop(){
        return history.pop();
    }

    /**
     * 检查是否为空
     * @return
     */
    public boolean isEmpty(){
        return history.isEmpty();
    }
}
