package con.example.liushaohua02.androiddemolist.Thread;
import android.os.Bundle;
import android.util.Log;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ThreadActivity extends BaseActivity {


    private static String TAG = "ThreadActivity";
    // 定义一个ThreadLocal对象，这里选择Boolean类型的
    private ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<Boolean>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        // 主线程设为 true
        mBooleanThreadLocal.set(true);
        Log.d(TAG, "[Thread#Main] mBooleanThreadLocal = " + mBooleanThreadLocal.get());
        
        // 子线程设为 false
        new Thread("Thread#1") {
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);

                Log.d(TAG, "[Thread#1] mBooleanThreadLocal = " + mBooleanThreadLocal.get());
            }
        }.start();
        
        // 子线程不设置
        new Thread("Thread#2") {
            @Override
            public void run() {
                
                Log.d(TAG, "[Thread#2] mBooleanThreadLocal = " + mBooleanThreadLocal.get());
            }
        }.start();


    }
}
