package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liushaohua02.androiddemo.R;

public class SplashActivity extends AppCompatActivity {


    private Button mBtnSkip;

    // 延迟3s用handle执行
    private Handler mHandle = new Handler();

    private Runnable mRunnableToLogin = new Runnable() {
        @Override
        public void run() {
            toLoginActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       mBtnSkip =  findViewById(R.id.btn_splash_skip);


        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 一定要移除mRunnableToLogin 否则会出现打开两次
                mHandle.removeCallbacks(mRunnableToLogin);
                toLoginActivity();
            }
        });

        // 3s执行执行 mRunnableToLogin 方法
        mHandle.postDelayed(mRunnableToLogin,3000);

    }

    private void toLoginActivity() {
        Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 避免造成内存泄漏 一定要移除  mRunnableToLogin

        mHandle.removeCallbacks(mRunnableToLogin);
    }
}
