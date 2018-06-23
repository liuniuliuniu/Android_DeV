package com.example.liushaohua02.androiddemolist.UISetting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

import java.util.Calendar;

public class ActivityToggleBtnAndRadioBtn extends BaseActivity {

    private ToggleButton togBtn;
    private RadioGroup rg;
    private ImageView imgV;
    private TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_btn_and_radio_btn);

        initView();
        addClick();
        setTime();

    }

    private void addClick() {
        togBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (togBtn.isChecked()){
                    rg.setVisibility(rg.VISIBLE);
                    imgV.setVisibility(imgV.VISIBLE);
                    textV.setVisibility(textV.VISIBLE);
                }else {
                    rg.setVisibility(rg.GONE);
                    imgV.setVisibility(imgV.GONE);
                    textV.setVisibility(textV.GONE);
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.Rb01:
                        imgV.setImageResource(R.drawable.meeting);
                        setTime();
                        break;
                    case R.id.Rb02:
                        imgV.setImageResource(R.drawable.office);
                        setTime();
                        break;
                    case R.id.Rb03:
                        imgV.setImageResource(R.drawable.visitor);
                        setTime();
                        break;
                }

            }
        });

    }

    private void initView() {
        togBtn = findViewById(R.id.ToggleBtn);
        rg = findViewById(R.id.RadioGroup);
        imgV = findViewById(R.id.imageView);
        textV = findViewById(R.id.textview);

        rg.setVisibility(rg.GONE);
        imgV.setVisibility(imgV.GONE);
        textV.setVisibility(textV.GONE);
    }

    private void setTime() {

        Calendar calendar = Calendar.getInstance();

        int Year,Month,Day,Hour,Minute,Sec;

        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        Hour = calendar.get(Calendar.HOUR);
        Minute = calendar.get(Calendar.MINUTE);
        Sec = calendar.get(Calendar.SECOND);

        textV.setText("当前时间："+Year+"-"+Month+"-"+Day+" "+Hour+":"+Minute+":"+Sec);

    }


}
