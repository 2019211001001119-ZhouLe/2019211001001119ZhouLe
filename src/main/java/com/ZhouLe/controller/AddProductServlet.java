package com.ZhouLe.controller;

import com.ZhouLe.dao.ProductDao;
import com.ZhouLe.model.Category;
import com.ZhouLe.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
public class AddProductServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList =  Category.findAllCategory(con);
            request.setAttribute("categoryList", categoryList);
            String path = "../WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request, response);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductName = request.getParameter("productName");
        System.out.println(ProductName);
        Double price = request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryID = request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String ProductDescription = request.getParameter("productDescription");

        InputStream inputStream = null;
        Part filePart = request.getPart("picture");
        if(filePart!=null){
            System.out.println("file name :"+filePart.getName()+"   size:"+filePart.getSize()+" file type"+filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        Product product = new Product();
        product.setProductName(ProductName);
        product.setCategoryID(categoryID);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setProductDescription(ProductDescription);
        System.out.println(product.toString());

        ProductDao dao = new ProductDao();
        int i = 0;
        try {
            i = dao.save(product, con);
            response.sendRedirect("productList");
        } catch (SQLException throwable){
            throwable.printStackTrace();
        }
    }
}
