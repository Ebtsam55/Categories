package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FollowCompanyModel implements Serializable {

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

    @SerializedName("phone")
    private int phone;

    @SerializedName("role")
    private int role;

    @SerializedName("status")
    private int status;




}
