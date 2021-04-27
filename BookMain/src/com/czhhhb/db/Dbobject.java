package com.czhhhb.db;

import com.czhhhb.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Dbobject {
    private Connection conn = null;

    public void connect() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/czhhhb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String user = "root";
        String pwd = "123456";//修改成你自己数据库的密码
        try {
            Class.forName(driver);
            this.setConn(DriverManager.getConnection(url, user, pwd));
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到jar包");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }


    //模糊查询
    public ArrayList<Book> SerchBook(String bookname) {//根据具体序号查询是否有这本书
        ArrayList<Book> booklist = new ArrayList<Book>();//返回学生列表根据列表大小判断有没有找到
        this.connect();
        try {
            String sql = "select * from book where name like '%"+bookname+"%'";
            System.out.println(sql);
            Statement stmt = null;
            stmt = this.conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.isBeforeFirst()) {
                System.out.println("编号\t \t书名\t\tIBSN\t\t");
                while (rs.next()) {
                    Book book = new Book();
                    book.setName(rs.getString("name"));
                    book.setPrice(rs.getString("Price"));
                    book.setSell(rs.getString("Sell"));
                    System.out.println("书名" + book.getName() + "\t \t价格" + book.getPrice() + "\t\t销量" + book.getSell());
                    booklist.add(book);
                }
                System.out.println("查询成功");
                this.conn.close();
                return booklist;
            } else {
                System.out.println("查询失败");
                this.conn.close();
                return booklist;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("查询失败");
            try {
                this.conn.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return booklist;
        }

    }

}
