package com.example.liushaohua02.androiddemolist.TransferMessage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivityTransferMessage extends BaseActivity {


    public static final String BUTON_TITLE = "Buton_Title";
    private Button button01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_message);



         findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 InvokeActivity();
             }
         });

    }


    // 生命周期 回调


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK){
            if (data != null){
                setTitle(data.getStringExtra("res"));
            }
        }
    }


    private void InvokeActivity() {


        Intent intent = new Intent(ActivityTransferMessage.this,ActivitySecondMessage.class);
        // 第一种方式传值
//            intent.putExtra("key","我是第一个页面传过来的");

        // 第二种方式
//            Bundle bundle = new Bundle();
//            bundle.putString(BUTON_TITLE,"我的Bundle");
//            intent.putExtra(BUTON_TITLE,bundle);

        // 第三种方式 实现序列化

        User user = new User();
        user.title = "我是第一个页面出过来的值";
        intent.putExtra(BUTON_TITLE,user);
        // 不需要回传值得方式
//            startActivity(intent);
// 需要回传值得花 需要定义code
        startActivityForResult(intent,999);

    }

}
