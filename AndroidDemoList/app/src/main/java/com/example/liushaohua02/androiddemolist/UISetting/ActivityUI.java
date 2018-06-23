package com.example.liushaohua02.androiddemolist.UISetting;

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

public class ActivityUI extends BaseActivity {

    public static final String Activity_TITLE = "Activity_Title";
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
        mlistItems.add(new listItem("ToggleBtnAndRadioBtn", ActivityToggleBtnAndRadioBtn.class));
        mlistItems.add(new listItem("ImageViewAndImageBtn", ActivityImageBtn.class));
        mlistItems.add(new listItem("RatingBar", ActivityRatingBar.class));
        mlistItems.add(new listItem("Btn四种监听方式", ActivityButton.class));
        mlistItems.add(new listItem("Menu", ActivityMenu.class));
        mlistItems.add(new listItem("UI控件的样式", ActivityUIStyle.class));

        mListView.setAdapter(new mainActivityAdaptor(ActivityUI.this,mlistItems));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class activity = mlistItems.get(position).getActivityName();
                Intent intent = new Intent(ActivityUI.this,activity);
                intent.putExtra(Activity_TITLE,mlistItems.get(position));
                startActivity(intent);
            }
        });

    }
}
