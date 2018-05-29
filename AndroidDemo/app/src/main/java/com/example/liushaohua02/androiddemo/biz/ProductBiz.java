package com.example.liushaohua02.androiddemo.biz;

import com.example.liushaohua02.androiddemo.bean.Product;
import com.example.liushaohua02.androiddemo.config.Config;
import com.example.liushaohua02.androiddemo.net.CommonCallBack;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;


public class ProductBiz {

    public void listByPage(int currentPage, CommonCallBack<List<Product>> callback) {
        OkHttpUtils
                .post()
                .url(Config.baseUrl + "product_find")
                .tag(this)
                .addParams("currentPage", currentPage + "")
                .build()
                .execute(callback);
    }


    public void onDestory() {
        OkHttpUtils.getInstance().cancelTag(this);
    }
}
