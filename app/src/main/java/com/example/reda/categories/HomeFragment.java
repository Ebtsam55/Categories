package com.example.reda.categories;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends Fragment {

    private Unbinder unbinder;
    private QuestionAnswerModel data = new QuestionAnswerModel();
    private FollowUnFollowModel followModelObj = new FollowUnFollowModel();
    private SendRecommendModel recommendModel=new SendRecommendModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);


        followModelObj.setUser_id(33);
        followModelObj.setFollow_id(34);
        followModelObj.setType("user");
        followModelObj.setSend_type("follow");


        recommendModel.setMessage("bjdsbhfhjkf");
        recommendModel.setUser_id(33);
        recommendModel.setRecommend_id(34);
        recommendModel.setProduct_id(20);

         loadCompanyRequest();

         loadProductRequest();

        loadQuestionRequest();

        performQuestionAnswer(data);

        FollowUnFollowReq(followModelObj);

        loadProductDetailsRequest();

       loadFollowedCompanyList();

       loadFollowedUsersList();

      loadRecommendationsFromUsers();

      LoadRecommendationsToUsers();

      sendRecommend(recommendModel);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void loadCompanyRequest() {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("categories/get-com-shop/4");
        VolleyHelper.loadCompany();

    }

    private void loadProductRequest() {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("products/7");
        VolleyHelper.loadProduct();

    }

    private void loadProductDetailsRequest() {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("products/get-product/20");
        VolleyHelper.loadProductDetails();

    }

    private void loadQuestionRequest() {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("products/question/6");
        VolleyHelper.loadQuestion();

    }

    private void performQuestionAnswer(QuestionAnswerModel data) {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.setQuestionAnswer(data);
        VolleyHelper.performQuestionAns();

    }

    private void FollowUnFollowReq(FollowUnFollowModel data) {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.setFollowUnFollow(data);
        VolleyHelper.requestFollowUnFollow();

    }

    private void loadFollowedCompanyList() {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("follows/company/33");
        VolleyHelper.requestFollowedCompanyList();

    }

    private void loadFollowedUsersList() {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("follows/user/33");
        VolleyHelper.requestFollowedUsersList();

    }


    private void loadRecommendationsFromUsers()
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("recommends/user-recommend/33");
        VolleyHelper.loadRecommendsFromUsers();
    }


    private void  LoadRecommendationsToUsers()
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("recommends/recommend-user/33");
        VolleyHelper.loadRecommendsToUsers();
    }

    private  void sendRecommend(SendRecommendModel data)
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.setRecommend(data);
        VolleyHelper.sendRecommend();

    }
}
