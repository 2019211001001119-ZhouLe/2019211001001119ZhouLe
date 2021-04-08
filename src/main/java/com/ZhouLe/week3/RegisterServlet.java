package com.ZhouLe.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"},
        initParams = {
                @WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"),
                @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/userdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"),
                @WebInitParam(name = "username", value = "root"),
                @WebInitParam(name = "password", value = "123456")
        },loadOnStartup = 1
)
public class RegisterServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username= config.getInitParameter("username");
        String password= config.getInitParameter("password");

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
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        String sex = request.getParameter("sex");

        PrintWriter writer = response.getWriter();
        String sql;
        sql = "INSERT INTO usertable (username,password,email,gender,birthdate) VALUES  ('" + name + "', '" + password + "', '" + email + "', '" + sex + "', '" + birthdate + "')";
        try {
            stmt.executeUpdate(sql);
            sql = "select * from usertable";
            ResultSet rs = stmt.executeQuery(sql);

            writer.println("<table border=\"1\">");
            writer.println("<tr>");
            writer.println("<th>"+"id"+"</th>");
            writer.println("<th>"+"username"+"</th>");
            writer.println("<th>"+"password"+"</th>");
            writer.println("<th>"+"email"+"</th>");
            writer.println("<th>"+"gender"+"</th>");
            writer.println("<th>"+"birthdate"+"</th>");
            writer.println("</tr>");
            while (rs.next()) {
                writer.println("<tr>");
                writer.println("<td>"+rs.getString("id")+"</td>");
                writer.println("<td>"+rs.getString("username")+"</td>");
                writer.println("<td>"+rs.getString("password")+"</td>");
                writer.println("<td>"+rs.getString("email")+"</td>");
                writer.println("<td>"+rs.getString("gender")+"</td>");
                writer.println("<td>"+rs.getString("birthdate")+"</td>");

            }
            writer.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.close();

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
