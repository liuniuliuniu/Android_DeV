package com.example.liushaohua02.androiddemolist.UISetting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivityButton extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);


        demo01();
        demo02();
        demo03();
        demo04();
    }

    private void demo04() {
    }

    public void onClickAction(View view) {
        Toast.makeText(ActivityButton.this,"demo04直接在xml方法中定义点击时间 然后在activity实现该方法即可",Toast.LENGTH_LONG).show();
    }




    private void demo03() {
        Button  button03 = (Button) findViewById(R.id.btn01);
        button03.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(ActivityButton.this,"第三种添加事件方式出门萨洛克才能马上离开查了库存",Toast.LENGTH_LONG).show();

    }

    private void demo02() {

        Button button02 = (Button) findViewById(R.id.btn01);

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ActivityButton.this,"点击了按钮",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void demo01() {

        Button button01 = (Button) findViewById(R.id.btn01);
        MyButtonListener listener = new  MyButtonListener();
        button01.setOnClickListener(listener);
    }

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(ActivityButton.this,"按钮被点击了",Toast.LENGTH_SHORT).show();
        }
    }
}
