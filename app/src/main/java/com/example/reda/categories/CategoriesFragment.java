package com.example.reda.categories;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CategoriesFragment extends Fragment {
    private Unbinder unbinder;
    public static ArrayList<CategoryModel> categoryList;
    public @BindView(R.id.categoryRecyclerView) RecyclerView recyclerView;
    public static CategoryAdapter adapter;
     private  GridLayoutManager gridLayoutManager;
     private CategoryModel model;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.categories_fragment,container,false);
        unbinder = ButterKnife.bind(this, view);

        model=new CategoryModel();
        categoryList =new ArrayList<>();
        adapter = new CategoryAdapter(getContext(), categoryList);
        recyclerView.setAdapter(adapter);

        gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

   //    loadCategoryRequest();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    private void loadCategoryRequest()
    {
        VolleyHelper.volleyInitialize(getContext());
        VolleyHelper.preparePath("categories");
        VolleyHelper.loadCategories();
        adapter.notifyDataSetChanged();
    }


}
