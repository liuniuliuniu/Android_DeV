package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.bean.User;
import com.example.liushaohua02.androiddemo.biz.UserBiz;
import com.example.liushaohua02.androiddemo.net.CommonCallBack;
import com.example.liushaohua02.androiddemo.utils.T;

public class RegisterActivity extends BaseActivity {

    private EditText mEdt_userName;
    private EditText mEdi_password;
    private EditText mEdi_password_two;
    private Button mbtn_register;

    private UserBiz mUserBiz = new UserBiz();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        setupToolbar();

        setupUI();

        setupEvent();

        setTitle("注册");
    }

    private void setupEvent() {

        mbtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = mEdt_userName.getText().toString();
                String passward = mEdi_password.getText().toString();
                String passwardtwo = mEdi_password_two.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(passward)) {
                    T.showToast("账号或者密码不能为空");
                    return;
                }

                if (!passward.equals(passwardtwo)){
                    T.showToast("两次输入的密码不一致");
                    return;
                }

                startProgressLoadig();

                mUserBiz.register(username, passward, new CommonCallBack<User>() {
                    @Override
                    public void onError(Exception e) {
                        stopProgressLoading();
                        T.showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(User response) {
                        stopProgressLoading();
                        T.showToast("注册成功");
                        LoginActivity.launch(RegisterActivity.this,response.getUsername(),response.getPassword());
                        // 完成后要销毁
                        finish();
                    }
                });


            }
        });

    }

    private void setupUI() {

        mEdt_userName = findViewById(R.id.register_username);
        mEdi_password = findViewById(R.id.register_password);
        mEdi_password_two = findViewById(R.id.register_passwordtwo);
        mbtn_register = findViewById(R.id.register_Btn);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUserBiz.onDestory();
    }
}
