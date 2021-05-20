package com.ZhouLe.model;

import java.io.InputStream;
import java.sql.Blob;

public class Product {
    private int ProductID;
    private String ProductName;
    private String ProductDescription;
    private InputStream picture;
    private double price;

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    private int CategoryID;

    public Product() {}

    public Product(int productID, String productName, String productDescription, InputStream picture, double price, int categoryID) {
        ProductID = productID;
        ProductName = productName;
        ProductDescription = productDescription;
        this.picture = picture;
        this.price = price;
        CategoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductID=" + ProductID +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", CategoryID=" + CategoryID +
                '}';
    }
}
