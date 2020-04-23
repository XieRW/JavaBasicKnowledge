package com.xierw.design.partterns.behavioralPattern.command.example1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 文字编辑器的 GUI
 *
 * @date 2020-04-23
 * @author xie
 * @email 1429382875@qq.com
 */
public class Editor {
    public JTextArea textField;
    public String clipboard;

    private CommandHistory history = new CommandHistory();

    public void init(){
        JFrame frame = new JFrame("Text editor (type & use buttons, xieRW!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Editor editor = this;
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excuteCommand(new CopyCommand(editor));
            }
        });
        ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excuteCommand(new CutCommand(editor));
            }
        });
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excuteCommand(new PasteCommand(editor));
            }
        });
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        });
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);
        frame.setSize(450,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    /**
     * 执行方法
     * @param command
     */
    private void excuteCommand(Command command){
        if (command.excute()){
            history.push(command);
        }
    }

    /**
     * 撤销
     */
    private void undo(){
        if (history.isEmpty()){
            return;
        }

        Command command = history.pop();
        if (command != null){
            command.undo();
        }
    }
}
