package com.practise.controller;

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
 * @program: tianshuo
 * @Description:
 * @Date: 2020/7/10 15:29
 **/
@WebServlet("/selectController")
public class SelectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(false);
        String  username = (String) session.getAttribute("username");

        Connection conn = JDBCUtils.getConn();
        String sql = "select * from user where username=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                resp.getWriter().println("用户个人信息");
                resp.getWriter().println("<br>");
                resp.getWriter().println("用户名："+rs.getString(2));
                resp.getWriter().println("<br>");
                resp.getWriter().println("密码："+rs.getString(3));
                resp.getWriter().println("<br>");
                resp.getWriter().println("邮箱："+rs.getString(4));
                resp.getWriter().println("<br>");
                resp.getWriter().println("手机号："+rs.getInt(5));
                resp.getWriter().println("<br>");
                resp.getWriter().println("注册时间："+rs.getString(6));
                resp.getWriter().println("<br>");
                resp.getWriter().println("修改时间："+rs.getString(7));
                /*req.setAttribute("flag2","rs.getString(2)");
                req.setAttribute("flag3","rs.getString(3)");
                req.setAttribute("flag4","rs.getString(4)");
                req.setAttribute("flag5",rs.getInt(5));
                req.setAttribute("flag6",rs.getString(6));
                req.setAttribute("flag7",rs.getString(7));
                req.getRequestDispatcher("/select.jsp").forward(req,resp);*/
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
