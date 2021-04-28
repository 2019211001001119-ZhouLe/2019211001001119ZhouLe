package com.ZhouLe.controller;

import com.ZhouLe.dao.UserDao;
import com.ZhouLe.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;
    @Override
    public void init() throws ServletException {
        conn = (Connection) getServletContext().getAttribute("conn");
        stmt = (Statement) getServletContext().getAttribute("stmt");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        String gender = request.getParameter("sex");
        User user = new User(id, username, password, email, gender, java.sql.Date.valueOf(birthdate));
        UserDao userDao = new UserDao();
        try {
            if(userDao.updateUser(conn, user)==0){
                request.setAttribute("message","update failed.");
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            }
            else {
                request.setAttribute("message","update success.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
    }
}
