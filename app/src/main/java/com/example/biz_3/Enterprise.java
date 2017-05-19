package com.example.biz_3;

/**
 * Created by ПОДАРУНКОВИЙ on 16.05.2017.
 */

public class Enterprise {
    public static String name;
    public static String description;
    public static String telephon;
    public static String city;
    public static String category;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Enterprise.name = name;
    }

    public Enterprise(String name, String description, String telephon, String city, String category) {
        this.name=name;
        this.description=description;
        this.telephon=telephon;
        this.city=city;
        this.category=category;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Enterprise.description = description;
    }

    public static String getTelephon() {
        return telephon;
    }

    public static void setTelephon(String telephon) {
        Enterprise.telephon = telephon;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        Enterprise.city = city;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        Enterprise.category = category;
    }
}
