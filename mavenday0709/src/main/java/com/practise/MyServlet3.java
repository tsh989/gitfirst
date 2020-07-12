package com.practise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: tsh
 * @program: workspace
 * @Description:
 * @Date: 2020/7/9 18:51
 **/
@WebServlet("/myServlet3")
public class MyServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(!username.equals("aaa")){
            resp.getWriter().println("username不存在");
        }
        if(!password.equals("123")){
            resp.getWriter().println("请重新输入");
        }
        else {
            resp.getWriter().println("ok");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(!username.equals("aaa")){
            resp.getWriter().println("username不存在");
        }
        else {
            resp.getWriter().println("ok");
        }
    }
}
