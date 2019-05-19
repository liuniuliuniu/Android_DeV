package com.example.liushaohua02.androidmolist.reflectActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.liushaohua02.androiddemolist.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectActivity extends AppCompatActivity {
    
    private static String TAG = "reflectActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);
    
        Log.e(TAG, "-------------------------------------------");
        try {
            //获取类DemoTest的Class对象
            Class c = null;
            // 直接通过类名得到
            c = LLPerson.class;
            // 通过对象的 getClass() 方法获取到
            Object object = new LLPerson();
            c = object.getClass();
            
            // 通过全类名获取，用的比较多，
            c = Class.forName("com.example.liushaohua02.androidmolist.reflectActivity.LLPerson");
            //打印该Class对象表示的类的名称
            Log.e(TAG, c.getName());
            
            //获取该类的实例
            Log.e(TAG, "c:" +  c.newInstance());
            Log.e(TAG, "-------------------------------------------");
            
            //获取该类实现的接口
            Class<?>[] interfaces = c.getInterfaces();
            System.out.println(interfaces[0].getName());
            Log.e(TAG, "-------------------------------------------");
            
            //获取有参构造函数
            Constructor<?> con = c.getConstructor(String.class, int.class);
            LLPerson dt = (LLPerson) con.newInstance("xiaoming", 12);
            Log.e(TAG, "age " + ((LLPerson) dt).getAge());
            Log.e(TAG, "-------------------------------------------");
            
            
            //获取类的成员变量
            Field f2 = c.getField("age");
            Log.e(TAG, "Field" + f2);
            //获取指定对象上该字段表示的值
            Log.e(TAG, "obj" + f2.get(dt));
            Log.e(TAG, "-------------------------------------------");
            //获取指定的方法
            Method m = c.getMethod("eat", String.class);
            //反射调用方法，非常重要
            m.invoke(dt, "麦当劳");
        
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
