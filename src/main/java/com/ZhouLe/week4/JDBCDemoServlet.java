package com.ZhouLe.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/JDBC"},
        initParams = {
                @WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"),
                @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/userdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"),
                @WebInitParam(name = "username", value = "root"),
                @WebInitParam(name = "password", value = "123456")
        },loadOnStartup = 1
)
public class JDBCDemoServlet extends HttpServlet {
    Connection conn = null;

//    @Override
//    public void init() throws ServletException {
//        ServletConfig config = getServletConfig();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username= config.getInitParameter("username");
//        String password= config.getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, username, password);
//            System.out.println(conn);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
