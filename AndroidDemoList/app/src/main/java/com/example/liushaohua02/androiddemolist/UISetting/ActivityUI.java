package com.example.liushaohua02.androiddemolist.UISetting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.liushaohua02.androiddemolist.R;
import com.example.liushaohua02.androiddemolist.mainActivityAdaptor;
import com.example.liushaohua02.androiddemolist.model.listItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityUI extends AppCompatActivity {

    private ListView mListView;
    private List<listItem> mlistItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        mListView = findViewById(R.id.uilistview);
        mlistItems = new ArrayList<listItem>();
        mlistItems.add(new listItem("Progress", ActivityUIProgress.class));
        mlistItems.add(new listItem("CheckBox", ActivityCheckBox.class));



        mListView.setAdapter(new mainActivityAdaptor(ActivityUI.this,mlistItems));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class activity = mlistItems.get(position).getActivityName();
                Intent intent = new Intent(ActivityUI.this,activity);
                startActivity(intent);
            }
        });
    }
}
