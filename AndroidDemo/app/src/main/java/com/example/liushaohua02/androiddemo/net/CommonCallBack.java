package com.example.liushaohua02.androiddemo.net;


import com.example.liushaohua02.androiddemo.utils.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;


//<T>  泛型 但是不确定具体是什么类型
public abstract class CommonCallBack<T> extends StringCallback {


    Type mType;

    public  CommonCallBack() {
        // 拿到当前的class对象
        Class<? extends CommonCallBack> aClass = getClass();
        // getGenericSuperclass 获取当前class的泛型
        Type genericSuperclass = aClass.getGenericSuperclass();

        if (genericSuperclass instanceof  Class) {
            throw new RuntimeException("Miss Type Patams");
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
//        返回的是泛型数组
       mType = parameterizedType.getActualTypeArguments()[0];

    }




    @Override
    public void onError(Call call, Exception e) {

        // 网络不可连接 超时等一些error
        onError(e);

    }

    @Override
    public void onResponse(Call call, String s) {

        try {
            JSONObject res = new JSONObject(s);

            int resultCode = res.getInt("resultCode");

            if (resultCode == 1) {

                String data = res.getString("data");

//                Gson gson = new Gson();
                // 将json字符串转换为type
                onSuccess((T) GsonUtil.getGson().fromJson(data,mType));

            }else  {
                // 返回服务端回来的提示
                onError(new RuntimeException(res.getString("resultMessage")));

            }

        } catch (JSONException e) {
            e.printStackTrace();
            // 服务端返回不合法的数据
            onError(e);
        }
    }

    // 抽象方法 那么该类也必须是抽象类
    public abstract void onError(Exception e);

    public abstract void onSuccess (T response);
}
