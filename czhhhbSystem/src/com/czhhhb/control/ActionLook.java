package com.czhhhb.control;

import com.czhhhb.db.Dbobject;
import com.czhhhb.model.Book;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionLook implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //实现图书查看功能，监听实现gui 并且调用数据库操作
        //直接显示现有全部图书，信息过多要有滚动条下拉
        JFrame frame =new JFrame();
        frame.setTitle("查看全部数据");
        Dbobject db=new Dbobject();
        ArrayList<Book> booklist=db.look();
        String[] columnNames =
                {"书名","价格", "销售量",};
        Object[][] obj = new Object[booklist.size()][9];
        int i=0;
        for (Book book : booklist) {
            obj[i][0]=book.getName();
            obj[i][1]=book.getPrice();
            obj[i][2]=book.getSell();
            i++;
        }
        JTable jtable = new JTable(obj, columnNames);
        TableColumn column = null;
        int colunms = jtable.getColumnCount();
        for(i = 0; i < colunms; i++)
        {
            column = jtable.getColumnModel().getColumn(i);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(100);
        }
        column = jtable.getColumnModel().getColumn(2);
        /*将每一列的默认宽度设置为100*/
        column.setPreferredWidth(200);
        /*
         * 设置JTable自动调整列表的状态，此处设置为关闭
         */
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
        JScrollPane scroll = new JScrollPane(jtable);
        scroll.setSize(500, 200);
        frame.add(scroll);
        frame.setLocation(500, 350);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
