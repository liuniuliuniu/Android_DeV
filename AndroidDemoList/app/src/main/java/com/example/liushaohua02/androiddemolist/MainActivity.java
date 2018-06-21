package com.example.liushaohua02.androiddemolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.CardView.CardViewActivity;
import com.example.liushaohua02.androiddemolist.Dialog.DialogActivity;
import com.example.liushaohua02.androiddemolist.Fragment.FragmentDemoActivity;
import com.example.liushaohua02.androiddemolist.JS.JSActivity;
import com.example.liushaohua02.androiddemolist.ListView.ChatActivity;
import com.example.liushaohua02.androiddemolist.ListView.appListActivity;
import com.example.liushaohua02.androiddemolist.TransferMessage.ActivityTransferMessage;
import com.example.liushaohua02.androiddemolist.model.listItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private ListView mListView;
    private List<listItem> mlistItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listview);
        mlistItems = new ArrayList<listItem>();
        mlistItems.add(new listItem("js交互", JSActivity.class));
        mlistItems.add(new listItem("listView使用",appListActivity.class));
        mlistItems.add(new listItem("聊天listView的使用", ChatActivity.class));
        mlistItems.add(new listItem("activity传值", ActivityTransferMessage.class));
        mlistItems.add(new listItem("CardView", CardViewActivity.class));
        mlistItems.add(new listItem("Dialog", DialogActivity.class));
        mlistItems.add(new listItem("Fragment", FragmentDemoActivity.class));
        mListView.setAdapter(new mainActivityAdaptor(mlistItems));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Class activity = mlistItems.get(position).getActivityName();
                Log.e(TAG,activity.toString());
                Intent intent = new Intent(MainActivity.this,activity);
                startActivity(intent);
            }
        });
    }

    public class mainActivityAdaptor extends BaseAdapter {
        Context mContext;
        List<listItem>listItems;

        public mainActivityAdaptor(List<listItem>listItems) {
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

                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_listitem,null);
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

}
