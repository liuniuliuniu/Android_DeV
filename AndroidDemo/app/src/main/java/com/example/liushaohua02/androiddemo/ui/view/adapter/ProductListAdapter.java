package com.example.liushaohua02.androiddemo.ui.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>{

    public  ProductListViewHolder onCreatViewHolder(ViewGroup viewGroup,int viewType) {
        

    };
    
    
    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {
        
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ProductListViewHolder extends RecyclerView.ViewHolder {


        public ProductListViewHolder(View itemView) {
            super(itemView);
        }
    }

}
