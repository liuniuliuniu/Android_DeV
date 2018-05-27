package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toolbar;

import com.example.liushaohua02.androiddemo.R;

public class BaseActivity extends AppCompatActivity {

    protected ProgressDialog mLoadingDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // 设置电池蓝颜色为黑色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xff000000);
        }

        mLoadingDialog = new ProgressDialog(this);
        mLoadingDialog.setMessage("拼命加载中....");

    }


    protected void startProgressLoadig() {
        mLoadingDialog.show();


    }
    protected void stopProgressLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    //  只能自己的子类调用
    protected void setupToolbar() {

        Toolbar toolbar = findViewById(R.id.id_toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

    }

    protected void toLoginActivity() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 一定记得销毁
        stopProgressLoading();
        mLoadingDialog = null;
    }
}
