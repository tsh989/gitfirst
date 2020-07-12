package com.practise.dao.impl;

import com.practise.dao.UserDao;
import com.practise.entity.User;
import com.practise.util.JdbcPoolUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.practise.entity.User;
import com.practise.service.impl.UserServiceImpl;
import com.practise.util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.practise.entity.User;
import com.practise.service.impl.UserServiceImpl;
import com.practise.util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther: tsh
 * @program: tianshuo
 * @Description:
 * @Date: 2020/7/10 13:36
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public int saveUser(User user) {
        int flag = 0;
        //用户名是否重复
        Connection conn = JDBCUtils.getConn();
        String sql1 = "select * from user";
        try {
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            wh:
            while (rs.next()) {
                if (rs.getString(2).equals(user.getUsername())) {
                    flag = 1;
                    //break wh;
                    return flag;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //邮箱是否合法
        String email=user.getEmail();
        String regx = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
        boolean matches = email.matches(regx);
        if(matches==false){
            flag=2;

        }
        //手机号是否合法
        String phone=user.getPhone();
        String regx2 = "[1][34578][0-9]{9}";
        boolean matches1 = phone.matches(regx2);
        if(matches1==false){
            flag=3;
        }

        //注册
        if (flag == 0) {
            String sql = "insert into user(username,password,email,phone,register_time,modify_time)values(?,?,?,?,NOW(),NOW())";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhone());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }



        /*QueryRunner qr = new QueryRunner(JdbcPoolUtils.getDataSource());
        String sql="insert into user(username,password,email,phone) values(?,?,?,?)";
        System.out.println(user.getUsername());
        try {
            qr.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),
                    user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        }
        return flag;
    }

    @Override
    public User signUser(User user) {
        Connection conn = JDBCUtils.getConn();
        String sql = "select * from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            wh:
            while (rs.next()) {
                if (rs.getString(2).equals(user.getUsername())
                        && rs.getString(3).equals(user.getPassword())) {
                    user.setFlag(1);
                    user.setEmail(rs.getString(4));
                    user.setPhone(rs.getString(5));
                    user.setRegister_time(rs.getString(6));
                    user.setModify_time(rs.getString(7));
                    break wh;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void selectUser(User user) {
        Connection conn = JDBCUtils.getConn();
        String sql = "select * from user where username=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}