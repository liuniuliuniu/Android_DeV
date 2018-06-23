package com.example.liushaohua02.androiddemolist.GridView.Adaptor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liushaohua02.androiddemolist.GridView.Model.ImageInfo;
import com.example.liushaohua02.androiddemolist.R;

import java.util.List;

public class GridAdaptor03 extends BaseAdapter {
    private Context context;
    private List<ImageInfo> imageInfos;

    public GridAdaptor03(Context context, List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return imageInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){

            convertView = View.inflate(context, R.layout.gridview_demo_item02,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView =convertView.findViewById(R.id.img_appIcon);
            viewHolder.textView  = convertView.findViewById(R.id.text_appName);
            convertView.setTag(viewHolder);
        }else  {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ImageInfo imageInfo = imageInfos.get(position);
        viewHolder.textView.setText(imageInfo.getText());

        // 网络加载图片
//        if (imageInfo.getBitmap() == null){
//            // 先显示默认的图片
//            viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
//        }else {
//
//            viewHolder.imageView.setImageBitmap(imageInfo.getBitmap());
//        }

//        // 使用第三方库直接接去加载
//        Glide.with(context)
//                .load(imageInfo.getImagePath())
//                .placeholder(R.mipmap.ic_launcher)// 站位图
//                .centerCrop()// 居中剪切
//                .into(viewHolder.imageView);// 加载到哪一个视图
        Glide.with(context).load(imageInfo.getImagePath()).into(viewHolder.imageView);

        return convertView;
    }


    public class ViewHolder {
        ImageView imageView;
        TextView textView;

    }


}
