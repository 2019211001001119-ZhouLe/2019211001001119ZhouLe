package com.ZhouLe.week3;

import com.ZhouLe.dao.UserDao;
import com.ZhouLe.model.User;
import com.ZhouLe.week4.JDBCDemoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
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
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        String sex = request.getParameter("sex");
        UserDao userDao = new UserDao();
        User user = null;
        user = new User(0, name, password, email, sex, java.sql.Date.valueOf(birthdate));
        try {
            userDao.saveUser(conn, user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("login.jsp");
//        PrintWriter writer = response.getWriter();
//        String sql;
//        sql = "INSERT INTO usertable (username,password,email,gender,birthdate) VALUES  ('" + name + "', '" + password + "', '" + email + "', '" + sex + "', '" + birthdate + "')";
//        try {
//            stmt.executeUpdate(sql);
//            sql = "select * from usertable";
//            ResultSet rs = stmt.executeQuery(sql);
//            response.sendRedirect("login.jsp");
//
//            writer.println("<table border=\"1\">");
//            writer.println("<tr>");
//            writer.println("<th>"+"id"+"</th>");
//            writer.println("<th>"+"username"+"</th>");
//            writer.println("<th>"+"password"+"</th>");
//            writer.println("<th>"+"email"+"</th>");
//            writer.println("<th>"+"gender"+"</th>");
//            writer.println("<th>"+"birthdate"+"</th>");
//            writer.println("</tr>");
//            while (rs.next()) {
//                writer.println("<tr>");
//                writer.println("<td>"+rs.getString("id")+"</td>");
//                writer.println("<td>"+rs.getString("username")+"</td>");
//                writer.println("<td>"+rs.getString("password")+"</td>");
//                writer.println("<td>"+rs.getString("email")+"</td>");
//                writer.println("<td>"+rs.getString("gender")+"</td>");
//                writer.println("<td>"+rs.getString("birthdate")+"</td>");
//
//            }
//            writer.println("</table>");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        writer.close();

    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
