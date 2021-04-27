package com.czhhhb.control;

import com.czhhhb.db.Dbobject;
import com.czhhhb.model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionDelete implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        //实现图书删除功能，监听实现gui 并且调用数据库操作
        //先输入要删除的编号，如果在数据库里面，则删除，出现界面提示删除成功
        //如果不存在数据，出现界面删除失败，无此书
    }
}
