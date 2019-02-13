package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchRequestModel implements Serializable {

    @SerializedName("subcategory")
    private int subcategory;

    @SerializedName("address")
    private int address;

    @SerializedName("company")
    private int company;

    @SerializedName("initial_price")
    private int initial_price;

    @SerializedName("final_price")
    private int final_price;

    @SerializedName("type")
    private ArrayList<Integer> type;

    public SearchRequestModel() {
        type = new ArrayList<Integer>();
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public int getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(int initial_price) {
        this.initial_price = initial_price;
    }

    public int getFinal_price() {
        return final_price;
    }

    public void setFinal_price(int final_price) {
        this.final_price = final_price;
    }

    public ArrayList<Integer> getType() {
        return type;
    }

    public void setType(ArrayList<Integer> type) {
        this.type = type;
    }
}
