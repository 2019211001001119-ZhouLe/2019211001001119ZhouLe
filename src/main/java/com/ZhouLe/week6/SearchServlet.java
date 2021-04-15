package com.ZhouLe.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("txt");
        String search = request.getParameter("search");
        if(text.length()==0)
        {
            response.sendRedirect("index.jsp");
        }
        else if (search.equals("baidu"))
            response.sendRedirect("https://www.baidu.com/s?wd="+text);
        else if (search.equals("bing"))
            response.sendRedirect("https://www.bing.com/search?q="+text);
        else if (search.equals("google"))
            response.sendRedirect("https://www.google.com/search?q="+text);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
