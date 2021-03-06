package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CompanyModel implements Serializable {

    @SerializedName("name_en")
    private String name_en;

    @SerializedName("name_ar")
    private String name_ar;


    @SerializedName("address_en")
    private String address_en;

    @SerializedName("address_ar")
    private String address_ar;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("id")
    private int id;

    @SerializedName("user_id")
    private int user_id;

    @SerializedName("number_shop")
    private int number_shop;

    @SerializedName("shops")
    private ShopModel[] shops;

    public CompanyModel() {
    }

    public ShopModel[] getShops() {
        return shops;
    }

    public void setShops(ShopModel[] shops) {
        this.shops = shops;
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

    public String getAddress_en() {
        return address_en;
    }

    public void setAddress_en(String address_en) {
        this.address_en = address_en;
    }

    public String getAddress_ar() {
        return address_ar;
    }

    public void setAddress_ar(String address_ar) {
        this.address_ar = address_ar;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNumber_shop() {
        return number_shop;
    }

    public void setNumber_shop(int number_shop) {
        this.number_shop = number_shop;
    }
}
