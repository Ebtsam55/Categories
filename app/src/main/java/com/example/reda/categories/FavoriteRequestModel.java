package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FavoriteRequestModel implements Serializable {
    @SerializedName("user_id")
    private int user_id;

    @SerializedName("product_id")
    private int product_id;

    public FavoriteRequestModel() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
