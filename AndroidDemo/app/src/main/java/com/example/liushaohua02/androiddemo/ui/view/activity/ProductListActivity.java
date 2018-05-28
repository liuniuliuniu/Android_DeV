package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefresh;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;


    private SwipeRefreshLayout mRefreshLayout;

    private TextView mTvCount;
    private Button mBtnPay;

    private int mCurrentPage = 0;
    private float mTotalPrice;
    private int mTotalCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        setTitle("详情页");

        setupView();

        setupEvent();



    }

    private void setupEvent() {


    }


    private void setupView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mTvCount = (TextView) findViewById(R.id.id_tv_count);
        mBtnPay = (Button) findViewById(R.id.id_btn_pay);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.id_refresh_layout);

        mRefreshLayout.setMode(SwipeRefresh.Mode.BOTH);
        mRefreshLayout.setColorSchemeColors(Color.RED, Color.BLACK, Color.BLUE, Color.GRAY);

        mRefreshLayout.setOnRefreshListener(new SwipeRefresh.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        mRefreshLayout.setOnPullUpRefreshListener(new SwipeRefreshLayout.OnPullUpRefreshListener() {
            @Override
            public void onPullUpRefresh() {
                loadMore();
            }
        });
    }

    private void loadMore() {


    }

    private void loadData() {
    }
}
