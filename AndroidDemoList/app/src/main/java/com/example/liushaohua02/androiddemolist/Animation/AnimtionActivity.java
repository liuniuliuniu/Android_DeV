package com.example.liushaohua02.androiddemolist.Animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class AnimtionActivity extends BaseActivity {
    
    private CustomAnimVIew mCustomAnimVIew;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animtion);
        
        mCustomAnimVIew = findViewById(R.id.customview);
        // 第一种平移动画
//        mCustomAnimVIew.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        // 第二种平移动画 属性动画 最简单的一种方式
        ObjectAnimator.ofFloat(mCustomAnimVIew,
                "translationX",
                0, 300).setDuration(1000).start();
        
    }
}
