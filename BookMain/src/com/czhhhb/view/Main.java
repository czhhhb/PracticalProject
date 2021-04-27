package com.czhhhb.view;

import com.czhhhb.control.*;
import com.czhhhb.db.Dbobject;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel contentPane=new JPanel();;//中间容器
    JLabel lblNewLabel = new JLabel("图书管理系统");//标签


    private JButton positionAdd=new JButton("图书添加");
    private JButton positionDelete=new JButton("图书删除");
    private JButton positionRecommend=new JButton("图书推荐");
    private JButton positionLook=new JButton("图书查看");
    private JButton positionChange=new JButton("图书修改"); //按钮部分
    private JButton positionSerch=new JButton("图书查询");
    public Main()
    {
        this.contentPane.setOpaque(false);//设 置不可拉框
        Image im;
        ImageIcon ig = new ImageIcon("D:\\java工作空间\\学生管理系统\\src\\view\\");
        im = ig.getImage();
        setIconImage(im);
        ImageIcon img = new ImageIcon("D:\\java工作空间\\学生管理系统\\src\\view\\");
        JLabel imgLabel = new JLabel(img);
        this.getLayeredPane().add(imgLabel,new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());//设置背景图片


        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);//设置布局 通过中间容器


        this.setBounds(100, 100, 600, 348);
        this.setTitle("图书管理系统");//设置标题


        this.add(this.lblNewLabel);
        this.lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));//设置标签
        this.lblNewLabel.setBounds(198, 37, 197, 43);

        this.add(this.positionAdd);
        this.add(this.positionDelete);
        this.add(this.positionRecommend);
        this.add(this.positionLook);
        this.add(this.positionChange);//设置按钮
        this.add(this.positionSerch);
        this.positionAdd.setBounds(90, 129, 120, 28);
        this.positionDelete.setBounds(382, 129, 120, 28);
        this.positionRecommend.setBounds(90, 181, 120, 28);
        this.positionLook.setBounds(382, 183, 120, 25);
        this.positionChange.setBounds(90, 237, 120, 23);//设置按钮位置
        this.positionSerch.setBounds(382, 237, 120, 25);


        ActionSerch serch = new ActionSerch();


        this.positionSerch.addActionListener(serch);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        this.setResizable(false);
        this.setVisible(true);//设置可见
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main MAIN=new Main();
    }

}
