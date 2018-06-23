package com.example.liushaohua02.androiddemolist.UISetting;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivityUIProgress extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiprogress);

        SeekBar seekbar = findViewById(R.id.seekbar);
        seekbar.setMax(100);
        seekbar.setProgress(30);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // fromUser  是否为人为拖动
                Log.i("progress", seekBar.getProgress() + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("progress",  "开始 +" + seekBar.getProgress() + "");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("progress",  "结束 +" + seekBar.getProgress() + "");
            }
        });






    }
}
