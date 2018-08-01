package com.example.liushaohua02.androiddemolist.Interface的使用;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.liushaohua02.androiddemolist.R;

public class InterfaceActivity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface02);


        findViewById(R.id.interface02_btn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyInterface1() {
                    @Override
                    public void fly() {

                    }
                }.fly();

            }
        });



    }
}
