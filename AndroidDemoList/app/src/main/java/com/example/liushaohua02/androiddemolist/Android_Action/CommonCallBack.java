package com.example.liushaohua02.androiddemolist.Android_Action;

public abstract class CommonCallBack {

    public static void Operation(CommonCallBack commonCallBack){

        commonCallBack.onFinish(false);

        commonCallBack.onSuccess(true);
    }


    // 抽象方法 那么该类也必须是抽象类
    public abstract void onFinish(Boolean finish);

    public abstract void onSuccess (Boolean success);

}
