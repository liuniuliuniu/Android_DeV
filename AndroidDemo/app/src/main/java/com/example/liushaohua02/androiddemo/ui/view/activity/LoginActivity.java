package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.UserInfoHolder;
import com.example.liushaohua02.androiddemo.bean.User;
import com.example.liushaohua02.androiddemo.biz.UserBiz;
import com.example.liushaohua02.androiddemo.net.CommonCallBack;
import com.example.liushaohua02.androiddemo.utils.T;

public class LoginActivity extends BaseActivity{


    private EditText mEd_UserName;
    private EditText mEd_PassWord;
    private Button mBtn_Login;
    private TextView mTxv_register;

    private UserBiz mUserBiz = new UserBiz();

    private static final String KEY_USERNAME = "KEY_USERNAME";
    private static final String KEY_PASSWORD = "KEY_PASSWORD";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        setupUI();

        setupEvent();

        initIntent(getIntent());
    }

    private void setupEvent() {

        mBtn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mEd_UserName.getText().toString();
                String passward = mEd_PassWord.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(passward)) {
                    T.showToast("账号或者密码不能为空");
                    return;
                }

                startProgressLoadig();

                mUserBiz.login(username, passward, new CommonCallBack<User>() {
                    @Override
                    public void onError(Exception e) {
                        stopProgressLoading();
                        T.showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(User response) {
                        stopProgressLoading();
                        T.showToast("登录成功");
                        // 保存用户信息
                        UserInfoHolder.getInstance().setUser(response);

                        toOrderActivity();
                    }
                });


            }
        });


        mTxv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRegisterActivity();
            }
        });

    }

    private void toRegisterActivity() {

        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void toOrderActivity() {

//        Intent intent = new Intent(this,OrderActivity.class);
//        startActivity(intent);
        // 不需要返回此控制器 就用finish将当前控制器释放

        // 隐式启动intent
        Intent intent = new Intent("android.intent.action.ALL_APPS");

        intent.addCategory("com.example.intent_test.MY_CATEGORY");

        startActivity (intent);

        finish();
    }

    private void setupUI() {
        mEd_UserName = findViewById(R.id.edt_username);
        mEd_PassWord = findViewById(R.id.edt_password);
        mBtn_Login = findViewById(R.id.btn_login);
        mTxv_register = findViewById(R.id.txv_register);
    }

    // 如果有activity 会走该方法 如果没有activity 会走onCreate方法
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        initIntent(intent);

    }

    private void initIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        String username = intent.getStringExtra(KEY_USERNAME);
        String password = intent.getStringExtra(KEY_PASSWORD);

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            return;
        }


        mEd_UserName.setText(username);
        mEd_PassWord.setText(password);
    }

    public static void launch(Context context, String username, String password) {

        Intent intent = new Intent(context,LoginActivity.class);
        // 清楚原有栈顶的登录activity
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(KEY_USERNAME,username);
        intent.putExtra(KEY_PASSWORD,password);
        context.startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserBiz.onDestory();
    }
}
