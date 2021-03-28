package com.ZhouLe.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name", value = "ZhouLe"),
                @WebInitParam(name = "ID", value = "2019211001001119")
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
    String name = null;
    String id = null;
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        name = config.getInitParameter("name");
        id = config.getInitParameter("ID");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("NAME : " + name);
        writer.println("ID : " + id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
