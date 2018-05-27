package com.example.liushaohua02.androiddemo.biz;

import com.example.liushaohua02.androiddemo.bean.Order;
import com.example.liushaohua02.androiddemo.bean.Product;
import com.example.liushaohua02.androiddemo.config.Config;
import com.example.liushaohua02.androiddemo.net.CommonCallBack;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;
import java.util.Map;

public class OrderBiz {

    public void listByPage(int currentPage, CommonCallBack<List<Order>> callback) {
        OkHttpUtils
                .post()
                .url(Config.baseUrl + "order_find")
                .tag(this)
                .addParams("currentPage", currentPage + "")
                .build()
                .execute(callback);
    }


    public void add(Order order, CommonCallBack callback) {

        Map<Product, Integer> productsMap = order.productsMap;

        StringBuilder sb = new StringBuilder();

        for (Product p : productsMap.keySet()) {

            sb.append(p.getId() + "_" + productsMap.get(p));

            sb.append("|");

        }
        sb = sb.deleteCharAt(sb.length() - 1);

        OkHttpUtils
                .post()
                .url(Config.baseUrl + "order_add")
                .addParams("res_id", order.getRestaurant().getId() + "")
                .addParams("product_str", sb.toString())
                .addParams("count", order.getCount() + "")
                .addParams("price", order.getPrice() + "")
                .tag(this)
                .build()
                .execute(callback);
    }

}
