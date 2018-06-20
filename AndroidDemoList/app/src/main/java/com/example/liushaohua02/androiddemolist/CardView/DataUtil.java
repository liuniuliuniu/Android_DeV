package com.example.liushaohua02.androiddemolist.CardView;

import com.example.liushaohua02.androiddemolist.R;

import java.util.ArrayList;
import java.util.List;


// 获取数据源方法
public class DataUtil {

    public static List<City> getData(){

        List<City> cities = new ArrayList<>();

        for (int i = 0;i<10;i++) {
            City city = new City(R.drawable.dizhonghai_line, "地中海");
            cities.add(city);
            City city2 = new City(R.drawable.rihan_line, "日韩线");
            cities.add(city2);
            City city3 = new City(R.drawable.hotline, "旅游热线");
            cities.add(city3);
        }
    return cities;
    }
}
