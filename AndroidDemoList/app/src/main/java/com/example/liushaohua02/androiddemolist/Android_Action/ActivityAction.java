package com.example.liushaohua02.androiddemolist.Android_Action;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

import java.util.Observable;
import java.util.Observer;

public class ActivityAction extends BaseActivity implements Observer{

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);


        tv = findViewById(R.id.maintxvid);

        findViewById(R.id.btnid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAction.this,ActivityActionSecond.class);
                startActivity(intent);
            }
        });
        // 注册观察者 通知的使用方式
        MyObserverable.getObserverable().addObserver(this);

        // 初始化监听器
        final Operate moperate = new Operate();
        moperate.setListener(new Listener() {
            @Override
            public void update(String string) {
                tv.setText(string);
            }
        });

        findViewById(R.id.btnlistenerid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moperate.doSomething("我是自定义事件");
            }
        });
    }

    // 当我们告诉观察者，信息发生改变的时候，调用此方法
    @Override
    public void update(Observable observable, Object data) {
        tv.setText(data.toString());
    }

    // 自定义listener
    public interface Listener {
        public void update(String string);
    }

    public class Operate {

        private Listener mListener;

        public void setListener(Listener listener) {
            mListener = listener;
        }
        public void doSomething(String string) {
            if (mListener != null) {
                mListener.update(string);
            }
        }
    }
}
