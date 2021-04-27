package com.czhhhb.control;

import com.czhhhb.db.Dbobject;
import com.czhhhb.model.Book;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionSerch implements ActionListener {

    public class frame2 extends JFrame {
        private JTextField text = new JTextField(20);
        JButton buttonseek=new JButton("模糊查询");
        JLabel lblNewLabel = new JLabel("请输入要查询的书名：");
        private JPanel contentPane;
        public frame2() {
            super("图书查询");
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
                ArrayList<Book> booklist=db.SerchBook(frame.text.getText());//根据图书编号获取图书列表
                String[] columnNames =
                        {"name","price", "sell"};
                Object[][] obj = new Object[booklist.size()][3];
                int i=0;
                for (Book x : booklist) {
                    obj[i][0]=x.getName();
                    obj[i][1]=x.getPrice();
                    obj[i][2]=x.getSell();
                    i++;
                }
                JTable jtable = new JTable(obj,columnNames);
                TableColumn column = null;
                int colunms = jtable.getColumnCount();
                for(i = 0; i < colunms; i++)
                {
                    column = jtable.getColumnModel().getColumn(i);
                    /*将每一列的默认宽度设置为100*/
                    column.setPreferredWidth(30);
                }

                JScrollPane scroll = new JScrollPane(jtable);
                scroll.setSize(100,50);
                frame.add(scroll);
                frame.setLocation(800, 450);
                frame.setSize(800, 200);
                frame.setVisible(true);
            }
        });
        //实现图书删除功能，监听实现gui 并且调用数据库操作
        //先输入要删除的编号，如果在数据库里面，则删除，出现界面提示删除成功
        //如果不存在数据，出现界面删除失败，无此书
    }
}

