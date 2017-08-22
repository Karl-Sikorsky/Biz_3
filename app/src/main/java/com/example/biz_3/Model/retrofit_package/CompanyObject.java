
package com.example.biz_3.Model.retrofit_package;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyObject {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("emails")
    @Expose
    private List<String> emails = null;
    @SerializedName("bankDetails")
    @Expose
    private BankDetails bankDetails;
    @SerializedName("products")
    @Expose
    private List<ProductR> products = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public List<ProductR> getProducts() {
        return products;
    }

    public void setProducts(List<ProductR> products) {
        this.products = products;
    }

}
