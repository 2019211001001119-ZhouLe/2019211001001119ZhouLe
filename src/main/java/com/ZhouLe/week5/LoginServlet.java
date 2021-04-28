package com.ZhouLe.week5;

import com.ZhouLe.dao.UserDao;
import com.ZhouLe.model.User;

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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(conn, name, password);
            if (user!=null) {
                HttpSession session = request.getSession();
                System.out.println("sessionID --->"+session.getId());
                session.setMaxInactiveInterval(10);

                Cookie c = new Cookie("sessionID", ""+user.getId());
                c.setMaxAge(10*60);
                response.addCookie(c);

                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }
            else {
                request.setAttribute("message","username or password wrong.");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
