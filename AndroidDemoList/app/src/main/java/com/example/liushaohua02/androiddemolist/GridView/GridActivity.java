package com.example.liushaohua02.androiddemolist.GridView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.liushaohua02.androiddemolist.R;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);


        findViewById(R.id.gridbtn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridActivity.this,GridActivity01.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.gridbtn02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridActivity.this,GridActiovity02.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.gridbtn03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GridActivity.this,GirdActivity03.class);
                startActivity(intent);
            }
        });

    }
}
