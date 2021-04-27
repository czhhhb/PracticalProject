package com.czhhhb.control;

import com.czhhhb.db.Dbobject;
import com.czhhhb.model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionDelete implements ActionListener {
    public class frame2 extends JFrame {
        private JTextField text = new JTextField(20);
        JButton buttonseek=new JButton("删除");
        JLabel lblNewLabel = new JLabel("请输入要删除的书名：");
        private JPanel contentPane;
        public frame2() {
            super("图书删除");
            setSize(400, 150);
            setLocationRelativeTo(null);
            contentPane=new JPanel();
            lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
            lblNewLabel.setBounds(198, 37, 100, 43);
            contentPane.add(lblNewLabel);
            setContentPane(contentPane);
            text.setBounds(250,37,100,100);
            add(text);
            add(buttonseek);
            setVisible(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame2 frame=new frame2();
        //删除按钮添加action
        frame.buttonseek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Dbobject db=new Dbobject();
                ArrayList<Book> booklist=db.SeekBook(frame.text.getText());//根据图书编号获取图书列表
                if(booklist.size()==1)
                {
                    db.delete(frame.text.getText());//根据编号删除图书
                    System.out.println("删除成功");
                    JFrame newframe=new JFrame();
                    newframe.setSize(240, 120);
                    newframe.setLocationRelativeTo(null);
                    JLabel lable = new JLabel("删除成功!");
                    lable.setBounds(70, 13, 60, 60);
                    newframe.add(lable);
                    newframe.setLayout(null);
                    newframe.setVisible(true);
                }
                else
                {
                    System.out.println("删除失败");
                    JFrame newframe=new JFrame();
                    newframe.setSize(240, 120);
                    newframe.setLocationRelativeTo(null);
                    JLabel lable = new JLabel("删除失败，无此书！");
                    lable.setBounds(55, 13, 200, 60);
                    newframe.add(lable);
                    newframe.setLayout(null);
                    newframe.setVisible(true);
                }

            }
        });
        //实现图书删除功能，监听实现gui 并且调用数据库操作
        //先输入要删除的编号，如果在数据库里面，则删除，出现界面提示删除成功
        //如果不存在数据，出现界面删除失败，无此书
    }
}
