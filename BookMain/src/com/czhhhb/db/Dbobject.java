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
        String pwd = "root";//修改成你自己数据库的密码
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

    public ArrayList<Book> SeekBook(String bookname) {//根据具体序号查询是否有这本书
        ArrayList<Book> booklist = new ArrayList<Book>();//返回学生列表根据列表大小判断有没有找到
        this.connect();
        try {
            String sql = "select * from library where name=" + bookname;
            System.out.println(bookname);
            Statement stmt = null;
            stmt = this.conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            if (rs.isBeforeFirst()) {
                System.out.println("书名\t \t价格\t\t评价数\t\t");
                while (rs.next()) {
                    Book book = new Book();
                    book.setName(rs.getString("name"));
                    book.setPrice(rs.getString("price"));
                    book.setEvaluate(rs.getString("evaluate"));
                    System.out.println("书名" + book.getName() + "\t \t价格" + book.getPrice() + "\t\t评价数" + book.getEvaluate());
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

    public int delete(String name)  {
        //删除数据  删除成功返回1，删除失败返回0
        try {
            if(this.SeekBook(name).size()==1) {
                this.connect();
                String sql = "delete from library where name =?";
                PreparedStatement pstmt;
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.execute();
                pstmt.close();
                conn.close();
                System.out.println("删除成功");
                return 1;
            }
            else {
                System.out.println("删除失败");
                return 0;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("删除报错");
            e.printStackTrace();
            try {
                conn.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return 0;
        }

    }

    //public ArrayList<Book> SeekBook(String booknum)
    //上面的这个查看编号方法是我自己写的 你们可以直接去调用
    //比如说要是添加书本 你总要判断添加书本的编号在不在数据库里面把 就可以调用我这个函数查看
    //其他自己数据库函数就对照我这个来写 比如说写AddBook
}
