package com.example.liushaohua02.androiddemo;

import android.app.Application;
import android.icu.util.TimeUnit;

import com.example.liushaohua02.androiddemo.utils.SPUtils;
import com.example.liushaohua02.androiddemo.utils.T;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import okhttp3.OkHttpClient;

public class ResApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化Toast
        T.init(this);
        SPUtils.init(this,"sp_user.pref");
    }
}
