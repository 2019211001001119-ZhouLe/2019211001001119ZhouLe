package com.ZhouLe.controller;

import com.ZhouLe.dao.ProductDao;
import com.ZhouLe.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "GetImgServlet", value = "/GetImg")
public class GetImgServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;
    @Override
    public void init() throws ServletException {
        conn = (Connection) getServletContext().getAttribute("conn");
        stmt = (Statement) getServletContext().getAttribute("stmt");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductDao dao = new ProductDao();
        int id =0;
        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
        }
        try {
            byte[] imgByte = new byte[0];
            imgByte = dao.getPictureByID(id,conn);
            if(imgByte!=null){
                response.setContentType("image/gif");
                OutputStream os = response.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
