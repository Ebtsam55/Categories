package com.example.reda.categories;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuestionAnswerModel implements Serializable {
    @SerializedName("question_id")
    private int question_id;

    @SerializedName("choice_id")
    private int[] questionChoices_arr ;

    public QuestionAnswerModel() {
        questionChoices_arr =new int[4];
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int[] getQuestionChoices_arr() {
        return questionChoices_arr;
    }

    public void setQuestionChoices_arr(int[] questionChoices_arr) {
        this.questionChoices_arr = questionChoices_arr;
    }
}
