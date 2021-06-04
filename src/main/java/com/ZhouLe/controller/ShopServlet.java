package com.ZhouLe.controller;

import com.ZhouLe.dao.ProductDao;
import com.ZhouLe.model.Category;
import com.ZhouLe.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    Connection conn = null;
    Statement stmt = null;
    @Override
    public void init() throws ServletException {
        conn = (Connection) getServletContext().getAttribute("conn");
        stmt = (Statement) getServletContext().getAttribute("stmt");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList = null;
        request.setAttribute("categoryList",categoryList);
        ProductDao productDao=new ProductDao();
        List<Product> productList=null;
        try{
            if(request.getParameter("categoryID")==null){
                productList=productDao.findAll(conn);
            }else {
                int categoryID=Integer.parseInt(request.getParameter("categoryID"));
                productList=productDao.findByCategoryId(categoryID,conn);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("productList",productList);
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
