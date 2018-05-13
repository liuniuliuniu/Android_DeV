package com.example.liushaohua02.cardview.entity;


// 模型 一定要设置set get方法  以及初始化方法
public class City {

    int iconID;
    String name;

    public City(int iconID, String name) {
        this.iconID = iconID;
        this.name = name;
    }


    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
