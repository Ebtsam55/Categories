package com.example.reda.categories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CategoryAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<CategoryModel> adapterModel;
    private final String REQUEST_KEY = "SUBCATEGORY";



    public CategoryAdapter(Context context, ArrayList<CategoryModel> adapterModel) {
        this.context = context;
        this.adapterModel = adapterModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.category_card,viewGroup,false);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((categoryViewHolder) viewHolder).BindView(i);
    }

    @Override
    public int getItemCount() {
        return adapterModel.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {

        TextView categoryStr;
        CardView cardView;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
          categoryStr=itemView.findViewById(R.id.category_str);
          cardView = itemView.findViewById(R.id.cat_card);




        }

        public void BindView(int i) {
          categoryStr.setText(adapterModel.get(i).getName_en());

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadSubCategoryRequest(String.valueOf(adapterModel.get(i).getId()));
                }
            });
        }
    }

    private void loadSubCategoryRequest(String id)
    {

        VolleyHelper.volleyInitialize(context);
        VolleyHelper.preparePath(id, REQUEST_KEY);
        Log.i("statuss", id);
        VolleyHelper.loadSubCategories();
    }




}
