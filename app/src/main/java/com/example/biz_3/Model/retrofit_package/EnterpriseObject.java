
package com.example.biz_3.Model.retrofit_package;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EnterpriseObject {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("emails")
    @Expose
    private List<String> emails = null;
    @SerializedName("regionName")
    @Expose
    private String regionName;
    @SerializedName("phones")
    @Expose
    private List<String> phones = null;
    @SerializedName("productsAndOffers")
    @Expose
    private String productsAndOffers;
    @SerializedName("categoriesId")
    @Expose
    private List<String> categoriesId = null;
    @SerializedName("companyRegionsId")
    @Expose
    private List<String> companyRegionsId = null;
    @SerializedName("deepCategoriesId")
    @Expose
    private List<String> deepCategoriesId = null;
    @SerializedName("deepRegionsId")
    @Expose
    private List<String> deepRegionsId = null;
    @SerializedName("upMainPageStartData")
    @Expose
    private String upMainPageStartData;
    @SerializedName("upCategoryStartData")
    @Expose
    private String upCategoryStartData;
    @SerializedName("upRegionStartData")
    @Expose
    private String upRegionStartData;
    @SerializedName("uprise")
    @Expose
    private Uprise uprise;

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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getProductsAndOffers() {
        return productsAndOffers;
    }

    public void setProductsAndOffers(String productsAndOffers) {
        this.productsAndOffers = productsAndOffers;
    }

    public List<String> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(List<String> categoriesId) {
        this.categoriesId = categoriesId;
    }

    public List<String> getCompanyRegionsId() {
        return companyRegionsId;
    }

    public void setCompanyRegionsId(List<String> companyRegionsId) {
        this.companyRegionsId = companyRegionsId;
    }

    public List<String> getDeepCategoriesId() {
        return deepCategoriesId;
    }

    public void setDeepCategoriesId(List<String> deepCategoriesId) {
        this.deepCategoriesId = deepCategoriesId;
    }

    public List<String> getDeepRegionsId() {
        return deepRegionsId;
    }

    public void setDeepRegionsId(List<String> deepRegionsId) {
        this.deepRegionsId = deepRegionsId;
    }

    public String getUpMainPageStartData() {
        return upMainPageStartData;
    }

    public void setUpMainPageStartData(String upMainPageStartData) {
        this.upMainPageStartData = upMainPageStartData;
    }

    public String getUpCategoryStartData() {
        return upCategoryStartData;
    }

    public void setUpCategoryStartData(String upCategoryStartData) {
        this.upCategoryStartData = upCategoryStartData;
    }

    public String getUpRegionStartData() {
        return upRegionStartData;
    }

    public void setUpRegionStartData(String upRegionStartData) {
        this.upRegionStartData = upRegionStartData;
    }

    public Uprise getUprise() {
        return uprise;
    }

    public void setUprise(Uprise uprise) {
        this.uprise = uprise;
    }

}
