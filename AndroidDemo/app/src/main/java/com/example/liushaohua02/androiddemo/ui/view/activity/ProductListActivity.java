package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.bean.Order;
import com.example.liushaohua02.androiddemo.bean.Product;
import com.example.liushaohua02.androiddemo.biz.OrderBiz;
import com.example.liushaohua02.androiddemo.biz.ProductBiz;
import com.example.liushaohua02.androiddemo.net.CommonCallBack;
import com.example.liushaohua02.androiddemo.ui.view.adapter.ProductListAdapter;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefresh;
import com.example.liushaohua02.androiddemo.ui.view.refresh.SwipeRefreshLayout;
import com.example.liushaohua02.androiddemo.ui.view.vo.ProductItem;
import com.example.liushaohua02.androiddemo.utils.T;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends BaseActivity {


    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;

    private ProductListAdapter mProductListAdapter;

    private TextView mTvCount;
    private Button mBtnPay;

    private OrderBiz mOrderBiz = new OrderBiz();
    private Order mOrder = new Order();

    private List<ProductItem>mDatas = new ArrayList<>();

    // 业务请求类
    ProductBiz mProductBiz = new ProductBiz();


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

        mProductListAdapter.setOnProductListener(new ProductListAdapter.OnProductListener() {
            @Override
            public void OnProductAdd(ProductItem productItem) {

                mTotalCount++;
                mTvCount.setText("数量为:" + mTotalCount);
                mTotalPrice += productItem.getPrice();
                mBtnPay.setText(mTotalPrice + "元 立即支付");

                mOrder.addProduct(productItem);

            }

            @Override
            public void OnProductSub(ProductItem productItem) {

                if (mTotalCount == 0) return;
                mTotalCount--;
                mTvCount.setText("数量为:" + mTotalCount);
                mTotalPrice -= productItem.getPrice();
                mBtnPay.setText(mTotalPrice + "元 立即支付");

                mOrder.removeProduct(productItem);
            }
        });

        mBtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mTotalCount <= 0){
                    T.showToast("您还没有选择菜品");
                    return;
                }

                mOrder.setCount(mTotalCount);
                mOrder.setPrice(mTotalPrice);
                mOrder.setRestaurant(mDatas.get(0).getRestaurant());

                startProgressLoadig();

                mOrderBiz.add(mOrder, new CommonCallBack() {
                    @Override
                    public void onError(Exception e) {
                        stopProgressLoading();
                        T.showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(Object response) {
                        stopProgressLoading();
                        T.showToast("订单支付成功");
                        setResult(RESULT_OK);

                        finish();
                    }
                });

            }
        });


    }


    private void setupView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mTvCount = (TextView) findViewById(R.id.id_tv_count);
        mBtnPay = (Button) findViewById(R.id.id_btn_pay);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.id_refresh_layout);

        mRefreshLayout.setMode(SwipeRefresh.Mode.BOTH);
        mRefreshLayout.setColorSchemeColors(Color.RED, Color.BLACK, Color.BLUE, Color.GRAY);


        mProductListAdapter = new ProductListAdapter(this,mDatas);
        mRecyclerView.setAdapter(mProductListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();
    }

    private void loadMore() {

        mProductBiz.listByPage(++mCurrentPage, new CommonCallBack<List<Product>>() {
            @Override
            public void onError(Exception e) {
                mCurrentPage --;
                T.showToast(e.getMessage());
                mRefreshLayout.setPullUpRefreshing(false);
            }

            @Override
            public void onSuccess(List<Product> response) {
                stopProgressLoading();

                mRefreshLayout.setPullUpRefreshing(false);

                if (response.size() == 0) {
                    T.showToast("没有菜了");
                    return;
                }
                T.showToast("又找到了" + response.size() + "道菜");

                for (Product product : response) {
                    mDatas.add(new ProductItem(product));
                }

                mProductListAdapter.notifyDataSetChanged();
            }
        });
    }

    private void loadData() {

        startProgressLoadig();

        mProductBiz.listByPage(0, new CommonCallBack<List<Product>>() {
            @Override
            public void onError(Exception e) {
                stopProgressLoading();

                T.showToast(e.getMessage());
            }

            @Override
            public void onSuccess(List<Product> response) {
                stopProgressLoading();

                mRefreshLayout.setRefreshing(false);
                mCurrentPage = 0;
                mDatas.clear();

                for (Product product : response) {
                    mDatas.add(new ProductItem(product));
                }

                mProductListAdapter.notifyDataSetChanged();

                mTotalCount = 0;
                mTotalPrice = 0;
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProductBiz.onDestory();
    }
}
