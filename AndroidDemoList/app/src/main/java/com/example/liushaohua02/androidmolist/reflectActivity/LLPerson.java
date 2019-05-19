package com.example.liushaohua02.androidmolist.reflectActivity;

import android.util.Log;

import java.io.Serializable;

public class LLPerson implements Serializable {
    public String name;
    public int age;
    
    public LLPerson() {
    
    }
    
    public LLPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat(String something) {
        Log.e("LLLLLLLL", "eat" + something);
    }
    
    private void privateMethod() {
        Log.e("LLLLLLL", "this is a privateMethod");
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}
