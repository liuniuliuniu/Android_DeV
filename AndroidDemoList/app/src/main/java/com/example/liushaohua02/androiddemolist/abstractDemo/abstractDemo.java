package com.example.liushaohua02.androiddemolist.abstractDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.liushaohua02.androiddemolist.R;

abstract class Abs {
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    private int age;
    
    public void tell() {
    
    }
    // 抽象方法
    public abstract void say();
    public abstract void print();
    
}

class AbsDemo extends Abs {
    @Override
    public void say() {
        Log.e("LLLLLLL",this.getAge() + "");
    }
    @Override
    public void print() {
        Log.e("LLLLLLL","现在的年龄" + this.getAge());
    }
    
    
}



public class abstractDemo extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_demo);
    
        AbsDemo absDemo = new AbsDemo();
        absDemo.setAge(100);
        
        absDemo.say();
        
        absDemo.print();
        
    }
}
