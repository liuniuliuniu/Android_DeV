package com.example.liushaohua02.androiddemolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.liushaohua02.androiddemolist.model.listItem;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (getIntent() != null) {
            Intent intent = getIntent();
            listItem item = (listItem) intent.getSerializableExtra("Activity_Title");
            if (item != null){
                setTitle(item.getMessage());
            }
        }
    }
}
