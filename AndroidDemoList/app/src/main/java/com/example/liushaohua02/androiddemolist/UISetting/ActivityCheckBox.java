package com.example.liushaohua02.androiddemolist.UISetting;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liushaohua02.androiddemolist.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityCheckBox extends AppCompatActivity {


    private CheckBox cbtravel,cbrun,cbread;
    private CheckBoxListener cbListener;
    private Button allBtn,notallBrn,btn_getInfo;
    private TextView textView;
    private btnActionListener btnlistener;

    private List<String> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        initView();
        initDate();
        initListener();
    }


    private void initDate() {
        lists = new ArrayList<String>();
    }

    private void initView() {
        // 初始化方法
        cbtravel = findViewById(R.id.travel);
        cbrun = findViewById(R.id.run);
        cbread = findViewById(R.id.read);
        allBtn = findViewById(R.id.btn_all);
        notallBrn = findViewById(R.id.btn_notall);
        btn_getInfo = findViewById(R.id.btn_getInfo);

        textView = findViewById(R.id.textview);

    }

    private void initListener() {

        cbListener = new CheckBoxListener();
        cbtravel.setOnCheckedChangeListener(cbListener);
        cbrun.setOnCheckedChangeListener(cbListener);
        cbread.setOnCheckedChangeListener(cbListener);

        btnlistener = new btnActionListener();
        allBtn.setOnClickListener(btnlistener);
        notallBrn.setOnClickListener(btnlistener);
        btn_getInfo.setOnClickListener(btnlistener);

    }

    // 内部函数类
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {

        @SuppressLint("WrongConstant")
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            CheckBox cb = (CheckBox) buttonView;

            switch (cb.getId()){
                case R.id.travel:

                    Toast.makeText(ActivityCheckBox.this,"旅游",1000).show();
                    break;
                case R.id.run:
                    Toast.makeText(ActivityCheckBox.this,"跑步",1000).show();
                    break;
                case R.id.read:
                    Toast.makeText(ActivityCheckBox.this,"读书",1000).show();
                    break;
            }
        }
    }


    class btnActionListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_all:
                    cbtravel.setChecked(true);
                    cbrun.setChecked(true);
                    cbread.setChecked(true);
                    break;
                case R.id.btn_notall:
                    cbtravel.setChecked(false);
                    cbrun.setChecked(false);
                    cbread.setChecked(false);
                    break;
                case R.id.btn_getInfo:

                    if (cbtravel.isChecked()) {
                        lists.add(cbtravel.getText().toString());
                    }
                    if (cbrun.isChecked()) {
                        lists.add(cbrun.getText().toString());
                    }
                    if (cbread.isChecked()) {
                        lists.add(cbread.getText().toString());
                    }
                    textView.setText(lists.toString());

                    lists.clear();

                    break;

            }

        }
    }
}
