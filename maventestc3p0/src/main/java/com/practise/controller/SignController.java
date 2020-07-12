package com.practise.controller;

import com.practise.entity.User;
import com.practise.service.impl.UserServiceImpl;

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
 * @Date: 2020/7/10 15:18
 **/
@WebServlet("/signController")
public class SignController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User user = new User(username, password);
        User user1= new UserServiceImpl().signUser(user);

        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        resp.getWriter().println(user.getFlag());


        /*int flag=0;
        Connection conn = JDBCUtils.getConn();
        String sql = "select * from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            wh:while (rs.next()) {
                if (rs.getString(2).equals(username)
                        && rs.getString(3).equals(password)) {
                    flag=1;
                    HttpSession session = req.getSession();
                    session.setAttribute("username",username);
                    resp.getWriter().println(flag);

                    break wh;
                }
            }
            if(flag==0){
                resp.getWriter().println(flag);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
