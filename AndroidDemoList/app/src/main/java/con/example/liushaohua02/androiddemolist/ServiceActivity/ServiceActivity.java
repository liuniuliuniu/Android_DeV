package con.example.liushaohua02.androiddemolist.ServiceActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.liushaohua02.androiddemolist.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    
    private static String TAG = "ServiceActivity";
    
    private Button btnStartService;
    private Button btnStopService;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        
        startService(new Intent(this, MusicService.class));  //启动服务，从而实现播放背景音乐
        
        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);
        
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                if (MusicService.isplay == false) {   //判断音乐播放的状态
                    startService(new Intent(ServiceActivity.this,
                            MusicService.class));  //启动服务，从而实现播放背景音乐
                }
                break;
            case R.id.btnStopService:
                
                if (MusicService.isplay != false) {   //判断音乐播放的状态
                    stopService(new Intent(ServiceActivity.this, MusicService.class));
                    //停止服务，从而实现停止播放背景音乐
                }
                break;
        }
    }
}
