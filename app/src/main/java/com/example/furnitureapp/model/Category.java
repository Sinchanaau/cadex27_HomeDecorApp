package com.example.furnitureapp.model;

public class Category {
    String fur_type1,fur_typ2;
    Integer image1,image2;

    public Category(String fur_type1, String fur_typ2, Integer image1, Integer image2) {
        this.fur_type1 = fur_type1;
        this.fur_typ2 = fur_typ2;
        this.image1 = image1;
        this.image2 = image2;
    }

    public String getFur_type1() {
        return fur_type1;
    }

    public void setFur_type1(String fur_type1) {
        this.fur_type1 = fur_type1;
    }

    public String getFur_typ2() {
        return fur_typ2;
    }

    public void setFur_typ2(String fur_typ2) {
        this.fur_typ2 = fur_typ2;
    }

    public Integer getImage1() {
        return image1;
    }

    public void setImage1(Integer image1) {
        this.image1 = image1;
    }

    public Integer getImage2() {
        return image2;
    }

    public void setImage2(Integer image2) {
        this.image2 = image2;
    }
}
