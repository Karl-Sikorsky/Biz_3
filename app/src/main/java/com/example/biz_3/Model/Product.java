package com.example.biz_3.Model;

/**
 * Created by Karl on 19.05.2017.
 */

public class Product {
    private String image;
    private String name;
    private double price;

    public Product(){}

    public Product(String image, String name, double price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }
    public Product(Product product){
        this.image = product.getImage();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
