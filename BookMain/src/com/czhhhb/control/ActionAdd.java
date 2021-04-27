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
    }
}