package com.example.liushaohua02.androiddemo.biz;

import com.example.liushaohua02.androiddemo.bean.User;
import com.example.liushaohua02.androiddemo.config.Config;
import com.example.liushaohua02.androiddemo.net.CommonCallBack;
import com.zhy.http.okhttp.OkHttpUtils;


import okhttp3.OkHttpClient;

public class UserBiz {


    public void login(String username, String password, CommonCallBack<User>commonCallBack) {

        OkHttpUtils
                .post()
                .url(Config.baseUrl + "user_login")
                .tag(this)
                .addParams("username",username)
                .addParams("password",password)
                .build()
                .execute(commonCallBack);
    }

    public void register(String username,String password,CommonCallBack<User>commonCallBack) {

        OkHttpUtils
                .post()
                .url(Config.baseUrl + "user_register")
                .tag(this)
                .addParams("username",username)
                .addParams("password",password)
                .build()
                .execute(commonCallBack);
    }

    public void onDestory() {
        OkHttpUtils.getInstance().cancelTag(this);
    }

}
