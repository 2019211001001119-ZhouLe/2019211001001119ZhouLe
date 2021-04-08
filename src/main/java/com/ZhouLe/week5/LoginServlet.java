package com.ZhouLe.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username= context.getInitParameter("username");
        String password= context.getInitParameter("password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sql;
        PrintWriter writer = response.getWriter();
        sql = "SELECT * from usertable where username ='"+name+"'and password ='"+password+"'";
        try {
            int i = 0;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) i++;
            if(i==0)
                writer.println("name or password wrong.");
            else{
                writer.println("Login Success!");
                writer.println("welcome " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
