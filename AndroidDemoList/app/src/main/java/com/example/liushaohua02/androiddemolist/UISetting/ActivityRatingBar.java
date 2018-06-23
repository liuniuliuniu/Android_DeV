package com.example.liushaohua02.androiddemolist.UISetting;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivityRatingBar extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        RatingBar ratingbar = findViewById(R.id.ratingBar);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ActivityRatingBar.this,"分数为" + rating,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
