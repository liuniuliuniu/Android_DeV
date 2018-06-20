package com.example.liushaohua02.androiddemolist.JS;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.R;

public class JSActivity extends Activity{

    private WebView mWebView;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jsactivity);

        mWebView = findViewById(R.id.webView);
        mTextView = findViewById(R.id.textView);

        // 允许webView加载JS代码
        mWebView.getSettings().setJavaScriptEnabled(true);

        // 给webview添加JS接口
        mWebView.addJavascriptInterface(new JSInterface(),"JSLAUNCHER");

    }
}
