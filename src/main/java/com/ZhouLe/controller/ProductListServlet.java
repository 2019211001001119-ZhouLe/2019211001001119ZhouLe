package com.ZhouLe.controller;

import com.ZhouLe.dao.ProductDao;
import com.ZhouLe.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;
    @Override
    public void init() throws ServletException {
        conn = (Connection) getServletContext().getAttribute("conn");
        stmt = (Statement) getServletContext().getAttribute("stmt");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao productDao=new ProductDao();
            List<Product> productList=productDao.findAll(conn);
            request.setAttribute("productList",productList);
        } catch (SQLException e){
            e.printStackTrace();
        }
        String path = "../WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
