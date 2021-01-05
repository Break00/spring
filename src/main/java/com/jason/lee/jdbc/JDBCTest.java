package com.jason.lee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author huanli9
 * @description
 * @date 2020/12/28 17:06
 */
public class JDBCTest {
    public static final String URL = "jdbc:mysql://localhost:3306/local";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, age FROM user");
        //4.获取数据
        while (rs.next()) {
            System.out.println(rs.getString("name") + " 年龄：" + rs.getInt("age"));
        }
    }
}
