package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.UserInfoHolder;
import com.example.liushaohua02.androiddemo.bean.Order;
import com.example.liushaohua02.androiddemo.bean.User;
import com.example.liushaohua02.androiddemo.biz.OrderBiz;
import com.example.liushaohua02.androiddemo.net.CommonCallBack;
import com.example.liushaohua02.androiddemo.ui.view.adapter.OrderAdapter;
import com.example.liushaohua02.androiddemo.ui.view.refresh.CircleTransform;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefresh;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefreshLayout;
import com.example.liushaohua02.androiddemo.utils.T;
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

    private OrderBiz mOrderBiz = new OrderBiz();

    private List<Order> mDatas = new ArrayList<>();

    private int mCurrentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setupUI();

        setupEvent();

        loadDatas();

    }

    private void setupEvent() {

        // 下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefresh.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadDatas();

            }
        });

        // 加载更多
        mSwipeRefreshLayout.setOnPullUpRefreshListener(new SwipeRefreshLayout.OnPullUpRefreshListener() {
            @Override
            public void onPullUpRefresh() {
                loadMore();
            }
        });

        mBtnTakeOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderActivity.this,ProductListActivity.class);

                // 调用这个方法启动activity的时候 可以重写下边的方法 来取到回调的值
                startActivityForResult(intent,1001);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_OK && requestCode == 1001) {

            loadDatas();
        }



    }

    private void loadMore() {

        mOrderBiz.listByPage(++mCurrentPage, new CommonCallBack<List<Order>>() {
            @Override
            public void onError(Exception e) {
                mSwipeRefreshLayout.setPullUpRefreshing(false);
                T.showToast(e.getMessage());
                mCurrentPage--;
            }

            @Override
            public void onSuccess(List<Order> response) {
                stopProgressLoading();
                mSwipeRefreshLayout.setPullUpRefreshing(false);
                if (response.size() == 0) {
                    T.showToast("没有订单了");

                    return;
                }
                T.showToast("订单加载成功了");
                mDatas.addAll(response);
                mAdapter.notifyDataSetChanged();
            }
        });



    }

    private void loadDatas() {

        mOrderBiz.listByPage(0, new CommonCallBack<List<Order>>() {
            @Override
            public void onError(Exception e) {
                if (mSwipeRefreshLayout.isRefreshing()){
                    mSwipeRefreshLayout.setRefreshing(false);
                }
                T.showToast(e.getMessage());
            }

            @Override
            public void onSuccess(List<Order> response) {

                T.showToast("订单更新成功");
                mCurrentPage = 0;

                mDatas.clear();
                mDatas.addAll(response);
                // 刷新数据
                mAdapter.notifyDataSetChanged();

                if (mSwipeRefreshLayout.isRefreshing()){
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }



    // 点击back 不直接退出app  还在后台运行可以重=重写此方法

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            try {
                // 一定要tryCatch 一下 找不到intent会报错的
                Intent home  = new Intent(Intent.ACTION_MAIN);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
                return true;
            }catch (Exception e) {

            }
        }

        return super.onKeyDown(keyCode, event);

    }

    private void setupUI() {


        mBtnTakeOrder = findViewById(R.id.id_btn_order);

        mIvIcon = findViewById(R.id.id_iv_icon);

        mTvName = findViewById(R.id.id_tv_username);

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

//        // 设置支持上下加载
        mSwipeRefreshLayout.setMode(SwipeRefresh.Mode.BOTH);
        // 设置主题
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLACK,Color.YELLOW,Color.GREEN);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new OrderAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);


        Picasso.with(this)
                .load(R.drawable.icon)
                .placeholder(R.drawable.pictures_no)
                .transform(new CircleTransform())
                .into(mIvIcon);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOrderBiz.onDestory();
    }
}
