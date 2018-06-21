package com.example.liushaohua02.androiddemolist.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.liushaohua02.androiddemolist.R;

public class ListFragment extends Fragment{


    public static final String BUNDLE_TITLE = "BUNDLE_TITLE";
    private String title = "默认值";

    private User mUser;

    public void setmUser(User mUser) {
        this.mUser = mUser;
    }

    public class User {

    }

    // 实例化fragment
    public static ListFragment newInstant(String title, User user) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE,title);
        fragment.setArguments(bundle);

        fragment.setmUser(user);
        return fragment;
    }

    // 传 基本类型值 在实例化
    public static ListFragment newInstance(String title) {

        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE,title);
        fragment.setArguments(bundle);

        return fragment;
    }


    //    fragment 和 activity相关连得时候调用
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(BUNDLE_TITLE);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    // 创建视图  最主要的生命周期
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 将activity传来的值 设置给Txt
        // 将fragment_list 赋值给当前视图
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        TextView textView = view.findViewById(R.id.textView_list);
        textView.setText(title);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 回调这个方法 在Main里边必须要实现这个方法
                if (monTitleCLickListener != null) {
                    monTitleCLickListener.onClick(title);
                }
            }
        });

        return view;
    }


    // fragment想activity传值  创建回调接口
//     设置接口的方法
    public void setOnTitleCLickListener(OnTitleCLickListener onTitleCLickListener) {
        this.monTitleCLickListener= onTitleCLickListener;
    }


    // 第二 定义变量
    OnTitleCLickListener monTitleCLickListener;


    // 第一创建接口
    public interface  OnTitleCLickListener {
        // 外界实现该方法
        void onClick(String title);
    }
}
