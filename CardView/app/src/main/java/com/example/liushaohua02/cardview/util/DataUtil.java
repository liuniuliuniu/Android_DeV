package com.example.liushaohua02.cardview.util;

import com.example.liushaohua02.cardview.R;
import com.example.liushaohua02.cardview.entity.City;

import java.util.ArrayList;
import java.util.List;


// 获取数据源方法
public class DataUtil {

    public static List<City> getData(){

        List<City> cities = new ArrayList<>();

        for (int i = 0;i<10;i++) {
            City city = new City(R.mipmap.dizhonghai_line, "地中海");
            cities.add(city);
            City city2 = new City(R.mipmap.rihan_line, "日韩线");
            cities.add(city2);
            City city3 = new City(R.mipmap.hotline, "旅游热线");
            cities.add(city3);
        }
    return cities;
    }
}
