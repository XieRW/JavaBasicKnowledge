package com.xierw.design.partterns.behavioralPattern.command.example1;

import com.sun.deploy.util.StringUtils;

/**
 * 从剪贴板粘贴文字
 *
 * @date 2020-04-23
 * @author xie
 * @email 1429382875@qq.com
 */
public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    /**
     * 执行命令
     * @return
     */
    @Override
    public boolean excute() {
        // 粘贴板未初始化或者值为空字符串，则不处理
        if (editor.clipboard == null || editor.clipboard.isEmpty()){
            return false;
        }

        // 先备份
        backup();
        // 然后把粘贴板的内容插入到选中的插入符号位置
        editor.textField.insert(editor.clipboard,editor.textField.getCaretPosition());
        return true;
    }
}
