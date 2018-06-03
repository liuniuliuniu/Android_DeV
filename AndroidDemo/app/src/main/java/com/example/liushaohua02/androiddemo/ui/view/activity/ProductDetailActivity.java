package com.example.liushaohua02.androiddemo.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.bean.Order;
import com.example.liushaohua02.androiddemo.bean.Product;
import com.example.liushaohua02.androiddemo.config.Config;
import com.example.liushaohua02.androiddemo.utils.T;
import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends BaseActivity {

    private Product mProduct;
    private static final String KEY_PRODUCT = "key_product";

    private ImageView mIvIcon;
    private TextView mTvTitle;
    private TextView mTvDesc;
    private TextView mTvPrice;



    public static void launch(Context context, Product product) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra(KEY_PRODUCT, product);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        setupToolbar();
        setupUI();
        setTitle("详情");
        initIntent();


    }

    private void initIntent() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        mProduct = (Product) intent.getSerializableExtra(KEY_PRODUCT);
        if (mProduct == null) {
            T.showToast("商品未取到");
            finish();
            return;
        }
    }

    private void setupUI() {

        mIvIcon = (ImageView) findViewById(R.id.id_iv_icon);
        mTvTitle = (TextView) findViewById(R.id.id_tv_title);
        mTvDesc = (TextView) findViewById(R.id.id_tv_desc);
        mTvPrice = (TextView) findViewById(R.id.id_tv_price);

        Picasso.with(this)
                .load(Config.baseUrl + mProduct.getIcon())
                .placeholder(R.drawable.pictures_no)
                .into(mIvIcon);

        mTvTitle.setText(mProduct.getName());
        mTvDesc.setText(mProduct.getDescription());
        mTvPrice.setText(mProduct.getPrice() + "元/份");
    }

}
