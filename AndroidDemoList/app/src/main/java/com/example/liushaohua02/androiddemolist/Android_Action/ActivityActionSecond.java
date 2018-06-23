package com.example.liushaohua02.androiddemolist.Android_Action;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.liushaohua02.androiddemolist.R;

public class ActivityActionSecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_second);

        findViewById(R.id.actionsecondBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 当事件触发，通知观察者
                MyObserverable.getObserverable().setMessage("传递过来的数据");
                finish();
            }
        });

    }
}
