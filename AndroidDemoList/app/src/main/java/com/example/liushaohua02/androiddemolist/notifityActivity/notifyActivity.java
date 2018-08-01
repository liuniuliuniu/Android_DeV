package com.example.liushaohua02.androiddemolist.notifityActivity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.liushaohua02.androiddemolist.R;

public class notifyActivity extends AppCompatActivity {
    
    
    private NotificationManager mNotificationManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        
        findViewById(R.id.notifyactivity_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            
            }
        });
        
        
        
        
        
        
    }
}
