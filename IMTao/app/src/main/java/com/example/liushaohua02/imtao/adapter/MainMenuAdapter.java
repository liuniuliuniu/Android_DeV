package com.example.liushaohua02.imtao.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liushaohua02.imtao.R;
import com.example.liushaohua02.imtao.entity.Menu;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter <MainMenuViewHolder> {

    protected Context context;
    private Activity activity;
    protected List<Menu> menus;

    public MainMenuAdapter(Context context, List<Menu> menus){
        this.context = context;
        this.menus = menus;

    }


    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 关联布局Layout  item
        return new MainMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_menu,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder holder, int position) {

       Menu menu = menus.get(position);
       holder.mImageMenuIcon.setImageResource(menu.icon);
       holder.mTexMenuName.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return menus != null ? menus.size() : 0;
    }

}


class MainMenuViewHolder extends RecyclerView.ViewHolder {

   public ImageView mImageMenuIcon;
    public TextView mTexMenuName;


    public MainMenuViewHolder(View itemView) {
        super(itemView);
        mImageMenuIcon = itemView.findViewById(R.id.item_main_menu_imgv);
        mTexMenuName = itemView.findViewById(R.id.item_main_menu_text);

    }
}


