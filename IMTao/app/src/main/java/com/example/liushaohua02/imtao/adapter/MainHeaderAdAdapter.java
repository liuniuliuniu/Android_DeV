package com.example.liushaohua02.imtao.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.List;

public class MainHeaderAdAdapter extends PagerAdapter{

   protected Context context ;
   protected List<ImageView>images;

    // 构建初始化方法

    public  MainHeaderAdAdapter(Context context ,List<ImageView>images){

        this.context = context;
        this.images = images;
    }


    @Override
    public int getCount() {
        return images != null ? images.size() : 0;
    }

    // 重写初始化方法
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imgV = null;
        if (images.size()>position)
        {
            container.addView(images.get(position));
            imgV = images.get(position);
        }
        
        
        return imgV;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    // 销毁的方法 不能super
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(images.get(position));
    }




}
