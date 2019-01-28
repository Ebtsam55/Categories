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
    private  QuestionAnswerModel data =new QuestionAnswerModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.home_fragment,container,false);

     // loadCompanyRequest();
     //  loadProductRequest();
     loadQuestionRequest();
      performQuestionAnswer( data);

   loadProductDetailsRequest();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void loadCompanyRequest()
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("categories/get-com-shop/4");
        VolleyHelper.loadCompany();

    }

    private void loadProductRequest()
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("products/7");
        VolleyHelper.loadProduct();

    }

    private void loadProductDetailsRequest()
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("products/get-product/20");
        VolleyHelper.loadProductDetails();

    }

    private void loadQuestionRequest()
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("products/question/6");
        VolleyHelper.loadQuestion();

    }

    private void performQuestionAnswer( QuestionAnswerModel data)
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.setQuestionAnswer(data);
        VolleyHelper.performQuestionAns();

    }
}
