package com.example.furnitureapp.model;

public class Cart {
    String prodname,prodprice;
    Integer imagedata;

    public Cart(String prodname, String prodprice, Integer imagedata) {
        this.prodname = prodname;
        this.prodprice = prodprice;
        this.imagedata = imagedata;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getProdprice() {
        return prodprice;
    }

    public void setProdprice(String prodprice) {
        this.prodprice = prodprice;
    }

    public Integer getImagedata() {
        return imagedata;
    }

    public void setImagedata(Integer imagedata) {
        this.imagedata = imagedata;
    }
}
