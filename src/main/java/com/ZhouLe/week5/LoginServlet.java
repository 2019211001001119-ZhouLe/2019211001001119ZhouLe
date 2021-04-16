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
        conn = (Connection) getServletContext().getAttribute("conn");
        stmt = (Statement) getServletContext().getAttribute("stmt");
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
        sql = "SELECT * from usertable where username ='"+name+"' and password ='"+password+"'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.next()) {
                request.setAttribute("message","username or password wrong.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else{
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",name);
                request.setAttribute("password",password);
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userinfo.jsp").forward(request, response);
                writer.println("Login Success!");
                writer.println("welcome " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
