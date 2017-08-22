
package com.example.biz_3.Model.retrofit_package;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uprise {

    @SerializedName("mainPage")
    @Expose
    private MainPage mainPage;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("region")
    @Expose
    private Region region;

    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
