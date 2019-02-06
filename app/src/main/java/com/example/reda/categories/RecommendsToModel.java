package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecommendsToModel implements Serializable {
    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("id")
    private int id;

    @SerializedName("user_id")
    private int user_id;

    @SerializedName("recommend_id")
    private int recommend_id;
    @SerializedName("product_id")
    private int product_id;

    @SerializedName("message")
    private String message;

    @SerializedName("recommend")
    private UserModel recommend_to;


    @SerializedName("product")
    private ProductModel recommend_product;

    public RecommendsToModel() {
    }

    public ProductModel getRecommend_product() {
        return recommend_product;
    }

    public void setRecommend_product(ProductModel recommend_product) {
        this.recommend_product = recommend_product;
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

    public int getRecommend_id() {
        return recommend_id;
    }

    public void setRecommend_id(int recommend_id) {
        this.recommend_id = recommend_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserModel getRecommend_to() {
        return recommend_to;
    }

    public void setRecommend_to(UserModel recommend_to) {
        this.recommend_to = recommend_to;
    }
}
