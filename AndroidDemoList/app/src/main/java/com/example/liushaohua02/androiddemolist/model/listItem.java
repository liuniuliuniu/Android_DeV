package com.example.liushaohua02.androiddemolist.model;

import java.io.Serializable;

public class listItem implements Serializable {

    private String message;
    private Class activityName;

    public listItem(String message, Class activityName){
        this.message = message;
        this.activityName = activityName;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Class getActivityName() {
        return activityName;
    }

    public void setActivityName(Class activityName) {
        this.activityName = activityName;
    }




}
