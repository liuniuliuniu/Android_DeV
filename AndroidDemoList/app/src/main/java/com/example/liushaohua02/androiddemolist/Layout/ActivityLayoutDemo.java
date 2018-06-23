package com.example.liushaohua02.androiddemolist.Layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;
import com.example.liushaohua02.androiddemolist.mainActivityAdaptor;
import com.example.liushaohua02.androiddemolist.model.listItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityLayoutDemo extends BaseActivity {

    public static final String Activity_TITLE = "Activity_Title";
    private ListView mListView;
    private List<listItem> mlistItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_demo);

        mListView = findViewById(R.id.layoutlistview);
        mlistItems = new ArrayList<listItem>();
        mlistItems.add(new listItem("表格布局", ActivityTableLayout.class));
        mlistItems.add(new listItem("网格布局", ActivityGridLayout.class));
        mlistItems.add(new listItem("相对布局", ActivityConstraintLayout.class));
        mlistItems.add(new listItem("FrameLayout", ActivityFrameLayout.class));
        mListView.setAdapter(new mainActivityAdaptor(ActivityLayoutDemo.this,mlistItems));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class activity = mlistItems.get(position).getActivityName();
                Intent intent = new Intent(ActivityLayoutDemo.this,activity);
                intent.putExtra(Activity_TITLE,mlistItems.get(position));
                startActivity(intent);
            }
        });


    }
}
