package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserRecommendsToModel implements Serializable {
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

    @SerializedName("facebook_id")
    private int facebook_id;

    @SerializedName("id")
    private int id;


    @SerializedName("phone")
    private String phone;

    @SerializedName("role")
    private int role;

    @SerializedName("status")
    private int status;

    @SerializedName("gender")
    private String gender;

    @SerializedName("email")
    private String email;

    @SerializedName("email_verified_at")
    private String email_verified_at;

    @SerializedName("lang")
    private String lang;


    @SerializedName("image")
    private String image;

    public UserRecommendsToModel() {
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

    public int getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(int facebook_id) {
        this.facebook_id = facebook_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
