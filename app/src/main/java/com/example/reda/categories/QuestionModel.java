package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuestionModel implements Serializable {
    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("description_ar")
    private String description_ar;

    @SerializedName("description_en")
    private String description_en;

    @SerializedName("id")
    private int id;

    @SerializedName("question_choice")
    private QuestionChoiceModel [] question_choice;

    public QuestionModel() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QuestionChoiceModel[] getQuestion_choice() {
        return question_choice;
    }

    public void setQuestion_choice(QuestionChoiceModel[] question_choice) {
        this.question_choice = question_choice;
    }
}
