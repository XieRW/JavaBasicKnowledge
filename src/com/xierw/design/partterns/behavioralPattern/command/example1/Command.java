package com.xierw.design.partterns.behavioralPattern.command.example1;

/**
 * 抽象基础命令
 *
 * @date 2020-04-23
 * @author xieRW
 * @email 1429382875@qq.com
 */
public abstract class Command {
    /**
     * 编辑器对象
     */
    Editor editor;
    /**
     * 备份内容
     */
    private String backup;

    Command(Editor editor){
        this.editor = editor;
    }

    /**
     * 备份
     */
    void backup(){
        backup = editor.textField.getText();
    }

    /**
     * 撤销
     */
    public void undo(){
        editor.textField.setText(backup);
    }

    /**
     * 抽象执行方法
     * @return
     */
    public abstract boolean excute();
}
