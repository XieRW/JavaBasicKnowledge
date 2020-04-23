package com.xierw.design.partterns.behavioralPattern.command.example1;

/**
 * 从剪贴板粘贴文字
 *
 * @date 2020-04-23
 * @author xie
 * @email 1429382875@qq.com
 */
public class CutCommand extends Command {

    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean excute() {
        if (editor.textField.getSelectedText().isEmpty()){
            return false;
        }

        backup();
        String source = editor.textField.getText();
        editor.clipboard = editor.textField.getSelectedText();
        editor.textField.setText(cutString(source));
        return true;
    }

    private String cutString(String source){
        String start = source.substring(0,editor.textField.getSelectionStart());
        String end = source.substring(editor.textField.getSelectionEnd());
        return start+end;
    }
}
