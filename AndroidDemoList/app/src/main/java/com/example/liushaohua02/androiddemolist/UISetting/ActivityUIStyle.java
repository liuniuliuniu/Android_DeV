package com.example.liushaohua02.androiddemolist.UISetting;

import android.os.Bundle;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivityUIStyle extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uistyle);

        TextView mTV = findViewById(R.id.textview_style);

    }
}
