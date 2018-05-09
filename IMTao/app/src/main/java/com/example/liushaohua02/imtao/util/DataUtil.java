package com.example.liushaohua02.imtao.util;


import android.content.Context;

import com.example.liushaohua02.imtao.entity.Menu;


//import android.view.Menu;

import android.widget.ImageView;
// 需要导入实体类的包


import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    /**
     *
     * @param context
     * @param icons
     * @return
     */
    public static List<ImageView> getHeaderAddInfo(Context context,int icons[]){
        List<ImageView>  datas=new ArrayList<>();
        for (int i = 0; i <icons.length ; i++) {
            ImageView  icon=new ImageView(context);
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            icon.setImageResource(icons[i]);
            datas.add(icon);
        }
        return datas;
    }

    /**
     * 主菜单
     * @param icons
     * @param names
     * @return
     */
    public static List<Menu>  getMainMenus(int icons[], String names[]){
        List<Menu>  menus=new ArrayList<>();

        for (int i = 0; i <icons.length ; i++) {
            Menu menu = new Menu(icons[i],names[i]);

            menus.add(menu);
        }
        return menus;
    }

}
