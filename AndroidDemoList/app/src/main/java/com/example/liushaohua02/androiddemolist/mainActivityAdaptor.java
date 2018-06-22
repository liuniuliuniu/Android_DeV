package com.example.liushaohua02.androiddemolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.model.listItem;

import java.util.List;

public class mainActivityAdaptor extends BaseAdapter {

    Context mContext;
    List<listItem> listItems;

    public mainActivityAdaptor(Context mContext, List<listItem>listItems) {
        this.mContext = mContext;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = new ViewHold();
        if (convertView == null){

            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_listitem,null);
            viewHold.mViewHodelTextV = convertView.findViewById(R.id.id_text);
            convertView.setTag(viewHold);
        }else {
            viewHold = (ViewHold)convertView.getTag();
        }
        viewHold.mViewHodelTextV.setText(listItems.get(position).getMessage());
        return convertView;
    }
    // 用于缓存的类
    public  class ViewHold {

        TextView mViewHodelTextV;

    }


}
