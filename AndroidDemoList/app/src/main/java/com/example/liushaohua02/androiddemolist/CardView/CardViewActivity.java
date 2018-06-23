package com.example.liushaohua02.androiddemolist.CardView;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

import java.util.List;

public class CardViewActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<City> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        recyclerView = findViewById(R.id.recycleView);

        cities = DataUtil.getData();

        // 设置 布局  LinearLayoutManager  列表的布局 GridLayoutManager( 网格的布局  StaggeredGridLayoutManager瀑布流格局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 设置 适配器
        recyclerView.setAdapter(new ImoocAdapter());

    }
    class ImoocItemDecoration extends RecyclerView.ItemDecoration{
        int space;
        public  ImoocItemDecoration(int space){
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            if(parent.getChildAdapterPosition(view)%2==0){
                outRect.top=50;
            }else{
                outRect.top=space;
            }
            outRect.bottom=space;

            outRect.left=space;
            outRect.right=space;

        }
    }

    // 实现 ImoocViewHolder
    class ImoocAdapter extends  RecyclerView.Adapter<ImoocViewHolder>{

        // 创建 ImoocViewHolder  传递数据
        @Override
        public ImoocViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView= LayoutInflater.from(CardViewActivity.this).inflate(R.layout.cardview_itemview,null);
            return new ImoocViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ImoocViewHolder holder, int position) {
            City city=cities.get(position);
            holder.mImgIcon.setImageResource(city.getIconID());
            holder.mTvName.setText(city.getName());
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }
    }


    class ImoocViewHolder extends  RecyclerView.ViewHolder{

        ImageView mImgIcon;
        TextView mTvName;
        public ImoocViewHolder(View itemView) {
            super(itemView);
            mImgIcon= (ImageView) itemView.findViewById(R.id.img_icon);
            mTvName= (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
