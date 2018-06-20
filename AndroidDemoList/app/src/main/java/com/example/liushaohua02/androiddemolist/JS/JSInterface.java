package com.example.liushaohua02.androiddemolist.JS;

import android.webkit.JavascriptInterface;

public class JSInterface {
    private static String TAG = "JSInterface";

    // 一定要加一个这个注解 否则web识别不了
    @JavascriptInterface
    public void setValue(String value){


    }

}
