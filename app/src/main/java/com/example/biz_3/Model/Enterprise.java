package com.example.biz_3.Model;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Karl on 16.05.2017.
 */

public class Enterprise extends RealmObject{
    private String name;
    private String description;
    private String telephon;
    private  String city;
    private  String category;
    private   String slug;
    //private List<Product> products;


    public  Enterprise(){}

   /* public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }*/

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enterprise(String name, String description, String telephon, String city, String category, String slug) {
        this.name=name;
        this.description=description;
        this.telephon=telephon;
        this.city=city;
        this.category=category;
        this.slug = slug;
    }

    public  String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }

    public  String getCity() {
        return city;
    }

    public  void setCity(String city){this.city = city;
    }

    public  String getCategory() {
        return category;
    }

    public  void setCategory(String category) {
        this.category = category;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
