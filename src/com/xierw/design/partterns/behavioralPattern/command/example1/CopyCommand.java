package com.xierw.design.partterns.behavioralPattern.command.example1;

/**
 * 将所选文字复制到剪贴板
 *
 * @date 2020-04-23
 * @author xieRW
 * @email 1429382875@qq.com
 */
public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    /**
     * 执行命令
     * @return
     */
    @Override
    public boolean excute() {
        // 将选中的文本内容赋值给粘贴板
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
