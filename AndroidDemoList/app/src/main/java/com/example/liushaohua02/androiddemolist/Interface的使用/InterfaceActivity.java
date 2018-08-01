package com.example.liushaohua02.androiddemolist.Interface的使用;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class InterfaceActivity extends BaseActivity implements  MyInterface1,MyInterface2 {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        Button btn01 = findViewById(R.id.interface_btn01);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(InterfaceActivity.this,InterfaceActivity02.class);

                startActivity(intent);
            }
        });


    }

    @Override
    public void fly() {
        Log.e("123","123");
    }

    @Override
    public void walk() {
        Log.e("123","123");
    }
}
