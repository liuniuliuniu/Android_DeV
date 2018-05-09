package com.example.liushaohua02.imtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.liushaohua02.imtao.fragment.FindFragment;
import com.example.liushaohua02.imtao.fragment.MainFragment;
import com.example.liushaohua02.imtao.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    protected LinearLayout mMenuMain,mMenuFind,mMenuMe;

    protected MainFragment  mMainFragment = new MainFragment();
    protected FindFragment mFindFragment = new FindFragment();
    protected MeFragment mMeFragment = new MeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container_content,mMainFragment)
                .add(R.id.container_content,mFindFragment).hide(mFindFragment)
                .add(R.id.container_content,mMeFragment).hide(mMeFragment)
                .commit();



    }

    private void initView() {
        mMenuMain = this.findViewById(R.id.menu_main);
        mMenuFind = this.findViewById(R.id.menu_find);
        mMenuMe = this.findViewById(R.id.menu_me);

        mMenuMain.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenuMe.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.menu_main:
                getFragmentManager()
                        .beginTransaction()
                        .show(mMainFragment)
                        .hide(mFindFragment)
                        .hide(mMeFragment)
                        .commit();

                break;

            case R.id.menu_find:
                getFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .show(mFindFragment)
                        .hide(mMeFragment)
                        .commit();
                break;

            case R.id.menu_me:
                getFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .hide(mFindFragment)
                        .show(mMeFragment)
                        .commit();
                break;
        }



    }
}
