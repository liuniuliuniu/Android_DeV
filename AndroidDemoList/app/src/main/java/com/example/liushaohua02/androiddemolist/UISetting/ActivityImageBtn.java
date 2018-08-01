package com.example.liushaohua02.androiddemolist.UISetting;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivityImageBtn extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_btn);


        findViewById(R.id.imageV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityImageBtn.this,"1111111",Toast.LENGTH_LONG).show();
            }
        });

    }

    // 为imageBtn添加点击事件
    public void ImageBtn(View view) {
        Toast.makeText(ActivityImageBtn.this,"huahauahu",Toast.LENGTH_LONG).show();
    }
}
