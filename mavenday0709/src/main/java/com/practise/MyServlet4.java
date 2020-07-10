package com.practise;

import com.practise.entity.User;
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

/**
 * @Auther: tsh
 * @program: workspace
 * @Description:
 * @Date: 2020/7/9 18:51
 **/
@WebServlet("/myServlet4")
public class MyServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        int flag=0;
        Connection conn = JDBCUtils.getConn();
        String sql = "select * from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            wh:while (rs.next()) {
                if (rs.getString(2).equals(username)
                        && rs.getString(3).equals(password)) {
                    flag=1;
                    resp.getWriter().println("ok");

                    break wh;
                }
            }
            if(flag==0){
                resp.getWriter().println("请重新输入");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*if(!username.equals("aaa")){
            resp.getWriter().println("username不存在");
        }
        if(!password.equals("123")){
            resp.getWriter().println("请重新输入");
        }
        else {
            resp.getWriter().println("ok");
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        int flag=0;
        Connection conn = JDBCUtils.getConn();
        String sql = "select * from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            wh:while (rs.next()) {
                if (rs.getString(2).equals(username)) {
                    flag=1;
                    resp.getWriter().println("ok");

                    break wh;
                }
            }
            if(flag==0){
                resp.getWriter().println("username不存在");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*if(!username.equals("aaa")){
            resp.getWriter().println("username不存在");
        }
        else {
            resp.getWriter().println("ok");
        }*/
    }
}
