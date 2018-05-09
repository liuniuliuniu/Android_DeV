package com.example.liushaohua02.imtao.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liushaohua02.imtao.R;
import com.example.liushaohua02.imtao.adapter.MainHeaderAdAdapter;
import com.example.liushaohua02.imtao.adapter.MainMenuAdapter;
import com.example.liushaohua02.imtao.util.DataUtil;

import java.util.List;

public class MainFragment extends Fragment {


    protected int [] icons = {R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2,R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad1};

    //菜单图标
    protected  int [] menuIons={
            R.mipmap.menu_airport,R.mipmap.menu_car
            ,R.mipmap.menu_course,R.mipmap.menu_hatol,
            R.mipmap.menu_nearby,R.mipmap.menu_nearby,
            R.mipmap.menu_ticket,R.mipmap.menu_train};

    protected String[] menus;

    protected ViewPager mVPageeHeaderAd;
    protected RecyclerView mRecyclerViewMenu;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 初始化数据 文字数组
        menus = this.getActivity().getResources().getStringArray(R.array.main_menu);


        // 轮播图的适配器
        mVPageeHeaderAd = (ViewPager)getView().findViewById(R.id.vpager_main_header_ad);
        MainHeaderAdAdapter adAdapter = new MainHeaderAdAdapter(getActivity(), DataUtil.getHeaderAddInfo(getActivity(),icons));
        mVPageeHeaderAd.setAdapter(adAdapter);

        // RecyclerView 的适配

        mRecyclerViewMenu = getView().findViewById(R.id.recycleview_main_menu);
        mRecyclerViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),4));
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getActivity(),DataUtil.getMainMenus(menuIons,menus));
        mRecyclerViewMenu.setAdapter(mainMenuAdapter);




    }
}
