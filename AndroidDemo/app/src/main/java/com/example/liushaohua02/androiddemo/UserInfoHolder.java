package com.example.liushaohua02.androiddemo;

import android.text.TextUtils;

import com.example.liushaohua02.androiddemo.bean.User;
import com.example.liushaohua02.androiddemo.utils.SPUtils;

public class UserInfoHolder {

    // 单例
    private static  UserInfoHolder mInstance = new UserInfoHolder();
    private User mUser;
    private static final String KEY_USERNAME = "KEY_USERNAME";

    public static UserInfoHolder getInstance() {
        return mInstance;
    }

    public void setUser(User user) {
        mUser = user;
        if (user != null) {
            SPUtils.getInstance().put(KEY_USERNAME,user.getUsername());
        }
    }

    public User getUser() {
        User user = mUser;

        if (user == null) {
            String username = (String) SPUtils.getInstance().get(KEY_USERNAME,"");
            if (!TextUtils.isEmpty(username)) {
                user = new User();
                user.setUsername(username);
            }
        }
        mUser = user;
        return user;
    }





}
