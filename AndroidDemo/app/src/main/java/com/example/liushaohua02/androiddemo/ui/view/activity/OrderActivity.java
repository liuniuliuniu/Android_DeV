package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.UserInfoHolder;
import com.example.liushaohua02.androiddemo.bean.Order;
import com.example.liushaohua02.androiddemo.bean.User;
import com.example.liushaohua02.androiddemo.ui.view.adapter.OrderAdapter;
import com.example.liushaohua02.androiddemo.ui.view.refresh.CircleTransform;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefresh;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefreshLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity {

    private Button mBtnTakeOrder;
    private ImageView mIvIcon;
    private TextView mTvName;

    private RecyclerView mRecyclerView;
    private OrderAdapter mAdapter;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Order> mDatas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setupUI();

        setupEvent();
    }

    private void setupEvent() {

    }

    private void setupUI() {

        mBtnTakeOrder = findViewById(R.id.id_btn_order);
        mIvIcon = findViewById(R.id.id_iv_icon);
        mTvName.findViewById(R.id.id_tv_username);
        mRecyclerView = findViewById(R.id.id_recycleview);
        mSwipeRefreshLayout = findViewById(R.id.id_SwipeRefreshLayout);


        User user = UserInfoHolder.getInstance().getUser();
        if (user != null){
            mTvName.setText(user.getUsername());
        }else  {
            toLoginActivity();
            finish();
            return;
        }

        // 设置支持上下加载
        mSwipeRefreshLayout.setMode(SwipeRefresh.Mode.BOTH);
        // 设置主题
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLACK,Color.YELLOW,Color.GREEN);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Picasso.with(this)
                .load(R.drawable.icon)
                .placeholder(R.drawable.pictures_no)
                .transform(new CircleTransform())
                .into(mIvIcon);

    }


}
