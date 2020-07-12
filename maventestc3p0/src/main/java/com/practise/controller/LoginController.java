package com.practise.controller;


import com.practise.entity.User;
import com.practise.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: tsh
 * @program: tianshuo
 * @Description: 注册操作
 * @Date: 2020/7/10 13:20
 **/
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //接收前台的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        //调用service层保存数据
        User user = new User(username,password,email,phone);
        int flag = new UserServiceImpl().saveUser(user);
        resp.getWriter().println(flag);
        /*int flag = 0;
        Connection conn = JDBCUtils.getConn();
        String sql1 = "select * from user";
        try {
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            wh:
            while (rs.next()) {
                if (rs.getString(2).equals(username)) {
                    flag = 1;
                    resp.getWriter().println(flag);
                    //resp.getWriter().println("用户名已存在");
                    break wh;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag == 0) {
            String sql = "insert into user(username,password,email,phone,register_time,modify_time)values(?,?,?,?,NOW(),NOW())";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ps.setInt(4, Integer.valueOf(phone));
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //响应

            resp.getWriter().println(flag);
        }*/
    }
}
