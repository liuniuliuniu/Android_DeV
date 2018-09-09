package com.example.liushaohua02.androiddemolist.Animation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by liushaohua02 on 2018/9/9.
 */

public class CustomAnimVIew extends View {
    
    
    private int lastX;
    
    private int lastY;
    
    public CustomAnimVIew(Context context) {
        super(context);
    }
    
    public CustomAnimVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public CustomAnimVIew(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        
        // 获取手指触摸点的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();
        
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                
                // 调用layout 方法来重新放置他的位置  第一种实现方式
//                layout(getLeft() + offsetX, getTop() + offsetY,
//                        getRight() + offsetX, getBottom() + offsetY);
                
                // 下边的代码和上边的效果是一样的 第二种方式
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
                // 第三种方式 获取布局信息 动态更改布局信息
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
            break;
        }
        return true;
    }
}
