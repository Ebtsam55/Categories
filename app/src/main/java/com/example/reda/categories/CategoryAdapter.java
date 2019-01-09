package com.example.reda.categories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
          categoryStr=itemView.findViewById(R.id.category_str);


        }

        public void BindView(int i) {
          categoryStr.setText(adapterModel.get(i).getName_en());
        }
    }




}
