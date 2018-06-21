package com.example.liushaohua02.androiddemolist.GridView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.liushaohua02.androiddemolist.R;

import java.util.ArrayList;
import java.util.List;

public class GridActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid01);


        GridView gridView = findViewById(R.id.gridView);
        List<String> stringList = new ArrayList<String>();

        for (int i = 0; i<9;i++){
            stringList.add("Grid"+i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_grid_item01,stringList);
        gridView.setAdapter(arrayAdapter);
    }

}
