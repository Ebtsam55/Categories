package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductSearchModel implements Serializable {
    @SerializedName("name_en")
    private String name_en;

    @SerializedName("name_ar")
    private String name_ar;

    @SerializedName("id")
    private int id;

    @SerializedName("category_id")
    private int category_id;


    @SerializedName("company_id")
    private int company_id;

    @SerializedName("type_id")
    private int type_id;

    @SerializedName("price")
    private int price;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("main_image")
    private String main_image;

    @SerializedName("description_ar")
    private String description_ar;

    @SerializedName("description_en")
    private String description_en;

    @SerializedName("has_offer")
    private String has_offer;

    public ProductSearchModel() {
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }

    public String getDescription_ar() {
        return description_ar;
    }

    public void setDescription_ar(String description_ar) {
        this.description_ar = description_ar;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public String getHas_offer() {
        return has_offer;
    }

    public void setHas_offer(String has_offer) {
        this.has_offer = has_offer;
    }
}
