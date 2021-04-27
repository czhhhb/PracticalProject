package com.czhhhb.control;

import com.czhhhb.db.Dbobject;
import com.czhhhb.model.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionAdd extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //实现图书增加功能，监听实现gui 并且调用数据库操作
        //输入图书信息，然后插入，如果图书的编号已经存在数据库 出现插入失败界面
        //如果编号不存在为一本新书 则出现插入成功界面
        JFrame jframe=new JFrame();
        jframe.setTitle("书籍信息录入");
        jframe.setSize(350, 300);
        JLabel JLabel_name = new JLabel("书名：");
        JLabel JLabel_price = new JLabel("价格：");
        JLabel JLabel_sell = new JLabel("销售量: ");

        JTextField JText_name = new JTextField("", 20);
        JTextField JText_price = new JTextField("", 20);
        JTextField JText_sell = new JTextField("", 20);


        JPanel JPanel_name =new JPanel();
        JPanel JPanel_price =new JPanel();
        JPanel JPanel_sell =new JPanel();

        JPanel_name.setBounds(0, 1, 336, 29);
        JPanel_price.setBounds(0, 28, 336, 29);
        JPanel_sell.setBounds(0, 55, 336, 29);


        JPanel_name.add(JLabel_name);
        JPanel_name.add(JText_name);

        JPanel_price.add(JLabel_price);
        JPanel_price.add(JText_price);

        JPanel_sell.add(JLabel_sell);
        JPanel_sell.add(JText_sell);


        JButton buttonadd = new JButton("添加");
        JButton buttonreturn = new JButton("返回");//按钮添加


        buttonadd.setBounds(0, 224, 168, 29);
        buttonreturn.setBounds(168, 224, 168, 29);//设置按钮位置

        buttonadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//设置监听
                Dbobject db=new Dbobject();
                Book book=new Book();
                book.setName(JText_name.getText());
                book.setPrice(JText_price.getText());
                book.setSell(JText_sell.getText());//调用数据库部分
                if(db.add(book)==1)//调用数据库插入函数 插入成功提示
                {
                    JFrame newframe=new JFrame();
                    newframe.setSize(240, 120);
                    newframe.setLocation(700, 450);
                    JLabel lable = new JLabel("插入成功!");
                    lable.setBounds(70, 13, 60, 60);
                    newframe.add(lable);
                    newframe.setLayout(null);
                    newframe.setLocationRelativeTo(null);
                    newframe.setVisible(true);
                }
                else//失败提示
                {
                    JFrame newframe=new JFrame();
                    newframe.setSize(240, 120);
                    newframe.setLocation(700, 450);
                    JLabel lable = new JLabel("插入失败!");
                    lable.setBounds(70, 13, 60, 60);
                    newframe.add(lable);
                    newframe.setLayout(null);
                    newframe.setLocationRelativeTo(null);
                    newframe.setVisible(true);
                }
            }
        });

        buttonreturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//设置监听
                jframe.dispose();
            }
        });//设置监听 点击退出按钮直接销毁窗体


        jframe.getContentPane().add(JPanel_name);
        jframe.getContentPane().add(JPanel_price);
        jframe.getContentPane().add(JPanel_sell);
        jframe.getContentPane().add(buttonadd);
        jframe.getContentPane().add(buttonreturn);//增加组件
        jframe.setLayout(null);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}