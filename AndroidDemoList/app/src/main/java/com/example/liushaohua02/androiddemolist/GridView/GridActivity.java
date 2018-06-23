package com.example.liushaohua02.androiddemolist.GridView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class GridActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);


        findViewById(R.id.gridbtn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridActivity.this,GridActivity01.class);
                intent.putExtra("Activity_TITLE","GridView加载文字");
                startActivity(intent);
            }
        });

        findViewById(R.id.gridbtn02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridActivity.this,GridActiovity02.class);
                intent.putExtra("Activity_TITLE","GridView获取手机应用列表");
                startActivity(intent);
            }
        });

        findViewById(R.id.gridbtn03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridActivity.this,GirdActivity03.class);
                intent.putExtra("Activity_TITLE","GridView获取网络图片");
                startActivity(intent);
            }
        });

    }
}
