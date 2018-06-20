package com.example.liushaohua02.androiddemolist.Cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.liushaohua02.androiddemolist.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CacheActivity extends AppCompatActivity {


    SharedPreferences preference ;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);


        /**现在不鼓励使用另外两种访问模式，在新版本的Android中不再鼓励访问其他应用的SharedPreference文件
         来完成应用之间的数据交换，而是使用ContentProvider*/
        preference = getSharedPreferences("setteddata", Context.MODE_PRIVATE);
        editor = preference.edit();
    }

    public void writeData(View view){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss");
        editor.putString("time", sdf.format(new Date()));
        editor.putInt("random", (int)(Math.random()*100));
        editor.commit();
    }

    public void readData(View view){
        String time = preference.getString("time", null);
        int random = preference.getInt("random", 0) ;
        String text = (time == null)? "您暂时未写入数据":"写入的数据为："+random+"\n写入的时间为"+time;
        Toast.makeText(CacheActivity.this, text , Toast.LENGTH_SHORT).show();
    }


}
