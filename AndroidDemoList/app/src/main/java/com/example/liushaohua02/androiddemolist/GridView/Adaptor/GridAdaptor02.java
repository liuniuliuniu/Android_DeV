package com.example.liushaohua02.androiddemolist.GridView.Adaptor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.GridView.Model.AppInfo;
import com.example.liushaohua02.androiddemolist.R;

import java.util.List;

public class GridAdaptor02 extends BaseAdapter {


    private Context context;
    private List<AppInfo> appInfos;

    public GridAdaptor02(Context context, List<AppInfo> appInfos) {
        this.appInfos = appInfos;
        this.context = context;
    }


    @Override
    public int getCount() {
        return appInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return appInfos.get(position);
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
            viewHolder.img_appIcon =convertView.findViewById(R.id.img_appIcon);
            viewHolder.tv_appName = convertView.findViewById(R.id.text_appName);
            convertView.setTag(viewHolder);
        }else  {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        AppInfo appInfo = appInfos.get(position);

        viewHolder.img_appIcon.setImageDrawable(appInfo.getAppIcon());
        viewHolder.tv_appName.setText(appInfo.getAppName() + " " + appInfo.getVersionName());

        return convertView;

    }


    public class ViewHolder {
        ImageView img_appIcon;
        TextView tv_appName;

    }
}
