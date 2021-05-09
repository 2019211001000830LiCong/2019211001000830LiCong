package com.LiCong.model;

import java.io.InputStream;

public class Product {
    private Integer productId;
    private  Integer categoryId;
    private String productname;
    private String picture;
    private String productDescription;
    private Double price;
    public Product(){}
    public  Product(Integer categoryId,String productname,Double price){
        this.categoryId = categoryId;
        this.productname = productname;
        this.price = price;
    }
    public  Product(Integer categoryId ,String productname,String productDescription,String picture,Double price){
        this.categoryId=categoryId;
        this.productname = productname;
        this.price = price;
        this.productDescription=productDescription;
        this.picture=picture;
    }
    public Integer getProductId(){
        return  this.productId;
    }
    public void setProductId(Integer productId){
        this.productId=productId;
    }
    public Integer getCategoryId(){
        return  this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String toString(){
        return "Product [ProductId="+productId+",cacategoryId="+categoryId+",productname="+productname+",productDescription="+productDescription
                +",picture="+picture+",price="+price+"]";

}
