package com.ZhouLe.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
        writer.println("<br>name :"+name);
        writer.println("<br>password :"+password);
        writer.println("<br>email :"+email);
        writer.println("<br>birthdate :"+birthdate);
        writer.println("<br>sex :"+sex);

        writer.close();
    }
}
