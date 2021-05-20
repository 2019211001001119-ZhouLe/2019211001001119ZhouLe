package com.ZhouLe.dao;

import com.ZhouLe.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product,InputStream picture, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, picture);
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryID());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        int n = 0;
        String sql = "DELETE FROM product WHERE ProductID = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, productId.toString());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "UPDATE product SET ProductName = ?, ProductDescription = ?, picture = ?, price = ?, CategoryID = ? WHERE ProductID = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryID());
        pt.setInt(6, instance.getProductID());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * from product where ProductID = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, productId.toString());
        ResultSet rs = pt.executeQuery();
        Product product = null;
        if(rs.next()) {
            product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            return product;
        }
        else
            return null;
    }

    @Override
    public List<Product> findByCategoryId(Integer categoryId, Connection con) throws SQLException {
        String sql = "SELECT * from product where CategoryID = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, categoryId.toString());
        ResultSet rs = pt.executeQuery();
        List products = new ArrayList();
        int i = 0;
        Product product = null;
        while(rs.next()) {
            product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
            i++;
        }
        if(i!=0)
            return products;
        else
            return null;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = "SELECT * from product where price between ? and ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, String.valueOf(minPrice));
        pt.setString(2, String.valueOf(maxPrice));
        ResultSet rs = pt.executeQuery();
        List products = new ArrayList();
        int i = 0;
        Product product = null;
        while(rs.next()) {
            product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
            i++;
        }
        if(i!=0)
            return products;
        else
            return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql = "SELECT * from product";
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        List products = new ArrayList();
        int i = 0;
        Product product = null;
        while(rs.next()) {
            product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
            i++;
        }
        if(i!=0)
            return products;
        else
            return null;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql = "SELECT * from product where ProductName = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, productName);
        ResultSet rs = pt.executeQuery();
        List products = new ArrayList();
        int i = 0;
        Product product = null;
        while(rs.next()) {
            product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
            i++;
        }
        if(i!=0)
            return products;
        else
            return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
}
