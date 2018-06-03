package com.example.liushaohua02.androiddemo.ui.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemo.R;
import com.example.liushaohua02.androiddemo.bean.Product;
import com.example.liushaohua02.androiddemo.config.Config;
import com.example.liushaohua02.androiddemo.ui.view.activity.ProductDetailActivity;
import com.example.liushaohua02.androiddemo.ui.view.vo.ProductItem;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListItemViewHolder>{

    private Context mContext;
    private List<ProductItem> mProductItems;
    private LayoutInflater mLayoutInflater;

    public ProductListAdapter(Context context, List<ProductItem>ProductItems){

        mContext = context;
        mProductItems = ProductItems;
        mLayoutInflater = LayoutInflater.from(context);

    }


    @NonNull
    @Override
    public ProductListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.item_product_list,parent,false);

        return new ProductListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListItemViewHolder holder, int position) {

        ProductItem productItem = mProductItems.get(position);
        Picasso.with(mContext)
                .load(Config.baseUrl + productItem.getIcon())
                .placeholder(R.drawable.pictures_no)
                .into(holder.mIvImage);

        holder.mTvName.setText(productItem.getName());
        holder.mTvLabel.setText(productItem.getLabel());
        holder.mTvCount.setText(productItem.count + "");
        holder.mTvPrice.setText(productItem.getPrice() + "元/份");



    }


    @Override
    public int getItemCount() {
        return mProductItems.size();
    }


    // 实现一个回调接口
    public interface OnProductListener {
        void OnProductAdd(ProductItem productItem);
        void OnProductSub(ProductItem productItem);
    }

    private OnProductListener mOnProductListener;

    public void setOnProductListener(OnProductListener productListener){
        mOnProductListener = productListener;
    }




    // 创建 item的viewhodle
    class ProductListItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView mIvImage;
        public TextView mTvName;
        public TextView mTvLabel;
        public TextView mTvPrice;

        public ImageView mImgAdd;
        public ImageView mImgSub;
        public TextView mTvCount;



        public ProductListItemViewHolder(View itemView) {
            super(itemView);

            mIvImage = (ImageView) itemView.findViewById(R.id.id_iv_image);
            mTvName = (TextView) itemView.findViewById(R.id.id_tv_name);
            mTvLabel = (TextView) itemView.findViewById(R.id.id_tv_label);
            mTvPrice = (TextView) itemView.findViewById(R.id.id_tv_price);
            mImgAdd = itemView.findViewById(R.id.id_iv_add);
            mImgSub = itemView.findViewById(R.id.id_iv_sub);
            mTvCount = (TextView) itemView.findViewById(R.id.id_tv_count);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ProductDetailActivity.launch(mContext,mProductItems.get(getAdapterPosition()));

                }
            });

            mImgAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // 获取当前位置
                    int pos = getLayoutPosition();
                    ProductItem productItem = mProductItems.get(pos);
                    productItem.count += 1;
                    mTvCount.setText(productItem.count + "");

                    // 回调activity计算总价格
                    if (mOnProductListener != null){
                        mOnProductListener.OnProductAdd(productItem);
                    }

                }
            });


            mImgSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getLayoutPosition();
                    ProductItem productItem = mProductItems.get(pos);

                    if (productItem.count>0) {
                        productItem.count -= 1;
                    }else  {
                        productItem.count = 0;
                    }
                    mTvCount.setText(productItem.count + "");

                    // 回调activity
                    if (mOnProductListener != null){
                        mOnProductListener.OnProductSub(productItem);
                    }
                }
            });

        }


    }

}
