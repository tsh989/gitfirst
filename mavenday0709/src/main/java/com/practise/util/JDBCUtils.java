package com.practise.util;

import java.sql.*;

/**
 * @Auther: tsh
 * @program: workspace
 * @Description:
 * @Date: 2020/6/29 12:29
 **/
public class JDBCUtils {
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/day0703";
    private static final String USER = "root";
    private static final String PASSWORD="123456";

    /**
     * 获取连接对象的公共方法
     * */
    public static Connection getConn(){
        Connection conn=null;
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源-增删改
     */
    public static void closeAll(Connection conn, PreparedStatement ps) {
        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源-包含查询
     */
    public static void closeAll(Connection conn, PreparedStatement ps,ResultSet rs) {
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
