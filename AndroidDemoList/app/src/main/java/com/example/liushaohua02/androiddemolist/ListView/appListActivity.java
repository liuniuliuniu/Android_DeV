package com.example.liushaohua02.androiddemolist.ListView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

import java.util.List;

public class appListActivity extends BaseActivity {

// 获取系统手机列表的app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);


        // 获取 当前 listVIew
        ListView listView = findViewById(R.id.appList_List_View);

        // 数据模型数组
        final List<ResolveInfo> listAppInfo = getAppInfo();
        // 设置listview的Adapter
        listView.setAdapter(new AppListAdapter(listAppInfo));


//        获取头部视图
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 给listView 添加点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // 获取手机中其他应用程序的 信息
                String appName = listAppInfo.get(position).activityInfo.packageName;

                String className = listAppInfo.get(position).activityInfo.name;

                // 组件 通过组件可以启动其他应用程序
                ComponentName componentName = new ComponentName(appName,className);

                Intent intent = new Intent();
                intent.setComponent(componentName);

                startActivity(intent);

            }
        });

    }


    /*
    * 获取应用的所有信息
    *
    *
    * */

    private List<ResolveInfo> getAppInfo() {
        Intent intent = new Intent(Intent.ACTION_MAIN,null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        return getPackageManager().queryIntentActivities(intent,0);

    }


    // AppListAdapter 适配器
    public class AppListAdapter extends BaseAdapter {

        List<ResolveInfo> resolveInfos;
         List<String> appNames;

         // 给适配器传递数组信息
        public  AppListAdapter( List<ResolveInfo> appNameList){
            resolveInfos = appNameList;

        }

        // 有多少条数据
        @Override
        public int getCount() {
            return resolveInfos.size();
        }

        // 获取当前position的数据
        @Override
        public Object getItem(int position) {
            return resolveInfos.get(position);
        }
        // 获取当前position
        @Override
        public long getItemId(int position) {
            return position;
        }

        // 数据和view的绑定
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHold viewHold = new ViewHold();
            // listView 优化 通过用ViewHold 去缓存
            if (convertView ==null) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView =  layoutInflater.inflate(R.layout.iterm_app_list_view,null);
                viewHold.mViewHodelImageV = convertView.findViewById(R.id.app_icon_image_view);
                viewHold.mViewHodelTextV = convertView.findViewById(R.id.app_icon_text_view);
                convertView.setTag(viewHold);
            }else {
                viewHold = (ViewHold)convertView.getTag();
            } ;


            ResolveInfo resolveInfo = resolveInfos.get(position);
            viewHold.mViewHodelTextV.setText(resolveInfo.loadLabel(getPackageManager()));
            viewHold.mViewHodelImageV.setImageDrawable(resolveInfo.loadIcon(getPackageManager()));

            // 设置点击事件的 第一种方式  可以指定具体的控件去添加事件
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {

//                    // 能够启动其他应用
//                    String appName = resolveInfos.get(position).activityInfo.packageName;
//
//                    String className = resolveInfos.get(position).activityInfo.name;
//
//                    ComponentName componentName = new ComponentName(appName,className);
//
//                    Intent intent = new Intent();
//                    intent.setComponent(componentName);
//
//                    startActivity(intent);

//                }
//            });

            return convertView;
        }

        // 用于缓存的类
        public  class ViewHold {

            ImageView mViewHodelImageV;
            TextView mViewHodelTextV;

        }


    }
}
