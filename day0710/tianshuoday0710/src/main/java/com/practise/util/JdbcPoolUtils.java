package com.practise.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcPoolUtils {

    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
    /**
     * 提供一个获取数据源的方法
     *
     * @return*/
    public static DataSource getDataSource(){
        return dataSource;
    }
    /**
     * 获取连接对象的方法
     * */
    public static Connection getConn() throws SQLException {
        Connection conn = dataSource.getConnection();
        return conn;
    }
    /**
     * 释放资源-增删改
     * */
    public static void closeAll(Connection conn, PreparedStatement ps){
        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放资源-有查询
     * */
    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
