package com.example.liushaohua02.androiddemolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.liushaohua02.androiddemolist.CardView.CardViewActivity;
import com.example.liushaohua02.androiddemolist.Dialog.DialogActivity;
import com.example.liushaohua02.androiddemolist.Fragment.FragmentDemoActivity;
import com.example.liushaohua02.androiddemolist.GridView.GridActivity;
import com.example.liushaohua02.androiddemolist.JS.JSActivity;
import com.example.liushaohua02.androiddemolist.ListView.ChatActivity;
import com.example.liushaohua02.androiddemolist.ListView.appListActivity;
import com.example.liushaohua02.androiddemolist.TransferMessage.ActivityTransferMessage;
import com.example.liushaohua02.androiddemolist.UISetting.ActivityUI;
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
        mlistItems.add(new listItem("UI各种样式的调整", ActivityUI.class));
        mlistItems.add(new listItem("js交互", JSActivity.class));
        mlistItems.add(new listItem("listView使用",appListActivity.class));
        mlistItems.add(new listItem("聊天listView的使用", ChatActivity.class));
        mlistItems.add(new listItem("activity传值", ActivityTransferMessage.class));
        mlistItems.add(new listItem("CardView", CardViewActivity.class));
        mlistItems.add(new listItem("Dialog", DialogActivity.class));
        mlistItems.add(new listItem("Fragment", FragmentDemoActivity.class));
        mlistItems.add(new listItem("GridVIew", GridActivity.class));
        mListView.setAdapter(new mainActivityAdaptor(MainActivity.this,mlistItems));

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

}
