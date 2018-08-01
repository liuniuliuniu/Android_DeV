package com.example.liushaohua02.androiddemolist.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class FragmentDemoActivity extends BaseActivity implements ListFragment.OnTitleCLickListener {


    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        findViewById(R.id.btn_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FragmentDemoActivity.this,StaticLoadFragmentActivity.class));
            }
        });



        // 动态加载
        // activity 像 fragment 传值
        // 1 创建fragment
        listFragment = ListFragment.newInstance("list");



        // 2 fragment管理器
        // 将fragment放进容器中fragment_listlayout
//        getSupportFragmentManager()
//                .beginTransaction()// 开启事物
//                .add(R.id.fragment_listlayout, listFragment)
//                 .commit();// 提交事物

//        getSupportFragmentManager().beginTransaction().add(R.id.fragment_listlayout,listFragment).commit();

        // 除了Add方法 还有remove replace  动态添加 移除  替换

//        // 设置监听者 并且实现监听者的方法
//        listFragment.setOnTitleCLickListener(this);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fragment_containnerlayout,ListFragment.newInstance("containner"))
//                .commit();


    }

    @Override
    public void onClick(String title) {
        if (title != null) {
            setTitle(title);
        }
    }
}
