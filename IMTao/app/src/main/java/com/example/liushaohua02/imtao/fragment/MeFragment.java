package com.example.liushaohua02.imtao.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.liushaohua02.imtao.R;

public class MeFragment extends Fragment {


    protected  Button mBtnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me,container,false);

    }


    // 需要在此方法中获取按钮
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mBtnLogin= (Button) getView().findViewById(R.id.menu_loginBtn);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登录
                Intent login=new Intent(getActivity(),LoginActivity.class);

                startActivity(login);
            }
        });

    }
}
