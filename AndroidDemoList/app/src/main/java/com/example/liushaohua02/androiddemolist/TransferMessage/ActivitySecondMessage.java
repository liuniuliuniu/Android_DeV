package com.example.liushaohua02.androiddemolist.TransferMessage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivitySecondMessage extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_message);

        Button btn = findViewById(R.id.btn01);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("res","我是第二个页面回传的值");

                setResult(RESULT_OK,intent);

                finish();
                }
            });

        // 防御 一定要做
        if (getIntent() != null) {
            Intent intent = getIntent();

//            // 第一种方式
//            String name = intent.getStringExtra("key");
//            setTitle(name);

            // 第二种方法
//            Bundle bundle = intent.getBundleExtra(MainActivity.BUTON_TITLE);
//            if (bundle != null) {
//                setTitle(bundle.getString(MainActivity.BUTON_TITLE));
//            }
            // 第三种方式
            User user = (User) intent.getSerializableExtra(ActivityTransferMessage.BUTON_TITLE);
            if (user != null){
                setTitle(user.title);
            }

        }

    }
}
