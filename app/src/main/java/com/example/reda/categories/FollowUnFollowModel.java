package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FollowUnFollowModel implements Serializable {

    @SerializedName("user_id")
    private int user_id;

    @SerializedName("follow_id")
    private int follow_id;

    @SerializedName("type")
    private String type;


    @SerializedName("send_type")
    private String send_type;

    public FollowUnFollowModel() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(int follow_id) {
        this.follow_id = follow_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSend_type() {
        return send_type;
    }

    public void setSend_type(String send_type) {
        this.send_type = send_type;
    }
}
