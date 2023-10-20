package com.example.furnitureapp.model;

public class Products2 {
    String product_name;
    String product_price;
    Integer image;
    Integer productid;

    public Products2(String product_name, String product_price, Integer image, Integer productid) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.image = image;
        this.productid = productid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }


}
