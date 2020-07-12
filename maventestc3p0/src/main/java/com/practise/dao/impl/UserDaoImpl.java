package com.practise.dao.impl;

import com.practise.dao.UserDao;
import com.practise.entity.User;
import com.practise.util.JDBCUtils;
import com.practise.util.JdbcPoolUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        /*Connection conn = JDBCUtils.getConn();
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
            }*/



        QueryRunner qr = new QueryRunner(JdbcPoolUtils.getDataSource());
        String sql="insert into user(username,password,email,phone,register_time,modify_time) values(?,?,?,?,NOW(),NOW())";
        try {
            qr.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),
                    user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public User signUser(User user) {
        //Connection conn = JDBCUtils.getConn();
        QueryRunner qr = new QueryRunner(JdbcPoolUtils.getDataSource());
        Connection conn = JdbcPoolUtils.getConn();
        String sql = "select * from user";
        try {
            List<User> userList = qr.query(conn, sql, new BeanListHandler<User>(User.class));
            f:for (User users : userList) {
                if(users.getUsername().equals(user.getUsername())&&
                users.getPassword().equals(user.getPassword())){
                    try {
                        Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(users.getRegister_time());
                        Date date2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(users.getModify_time());
                        String dateStr1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
                        String dateStr2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
                        user.set(users.getUsername(),users.getPassword(),users.getEmail(),users.getPhone(),dateStr1,dateStr2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    //user.set(users.getUsername(),users.getPassword(),users.getEmail(),users.getPhone(),dateStr1,dateStr2);
                    //user.set(users.getUsername(),users.getPassword(),users.getEmail(),users.getPhone(),users.getRegister_time(),users.getModify_time());
                    user.setFlag(1);
                    break f;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;


        /*try {
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
        }*/

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