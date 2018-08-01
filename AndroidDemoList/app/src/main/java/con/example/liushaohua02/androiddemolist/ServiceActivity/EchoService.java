package con.example.liushaohua02.androiddemolist.ServiceActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liushaohua02 on 2018/7/22.
 */

public class EchoService extends Service {
    private final EchoService.EchoServiceBinder echoServiceBinder = new EchoService.EchoServiceBinder();
    private int i = 0;
    private Timer timer = null;
    private TimerTask task = null;
    
    public EchoService() {
    }
    
    
    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return this.echoServiceBinder;
    }
    
    public int getCurrentNum() {
        return this.i;
    }
    
    
    public void onCreate() {
        System.out.println("onCreate");
        this.startTimer();
        super.onCreate();
    }
    
    public void onDestroy() {
        System.out.println("onDestory");
        this.stopTimer();
        super.onDestroy();
    }
    
    public void startTimer() {
        if(this.timer == null) {
            this.timer = new Timer();
            this.task = new TimerTask() {
                public void run() {
                    EchoService.this.i = EchoService.this.i + 1;
                    System.out.println(EchoService.this.i);
                }
            };
            this.timer.schedule(this.task, 1000L, 1000L);
        }
        
    }
    
    public void stopTimer() {
        if(this.timer != null) {
            this.task.cancel();
            this.timer.cancel();
            this.task = null;
            this.timer = null;
        }
        
    }
    
    
    public class EchoServiceBinder extends Binder {
        public EchoServiceBinder() {
        }
        
        public EchoService getService() {
            return EchoService.this;
        }
    }
}
