package com.example.liushaohua02.androiddemolist.Dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.liushaohua02.androiddemolist.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);


        BtnCLickListener lickListener = new BtnCLickListener();


        Button btn01 =  findViewById(R.id.btn01);
        Button btn02 =  findViewById(R.id.btn02);
        Button btn03 =  findViewById(R.id.btn03);
        Button btn04 =  findViewById(R.id.btn04);
        Button btn05 =  findViewById(R.id.btn05);
        Button btn06 =  findViewById(R.id.btn06);
        Button btn0 =  findViewById(R.id.btn0);
        Button btn7 =  findViewById(R.id.btn07);
        Button btn8 =  findViewById(R.id.btn08);


        btn0.setOnClickListener(lickListener);
        btn01.setOnClickListener(lickListener);
        btn02.setOnClickListener(lickListener);
        btn03.setOnClickListener(lickListener);
        btn04.setOnClickListener(lickListener);
        btn05.setOnClickListener(lickListener);
        btn06.setOnClickListener(lickListener);
        btn7.setOnClickListener(lickListener);
        btn8.setOnClickListener(lickListener);
    }


    class BtnCLickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn01:

                    AlertDemo01();


                    break;
                case R.id.btn0:

                    AlertDemo();

                    break;


                case R.id.btn02:


                    showListAlertDemo();

                    break;

                case R.id.btn03:

                    showSingleALertDemo();

                    break;


                case R.id.btn04:

                    showMutiAlertDemo();

                    break;

                case R.id.btn05:

                    showWaitProgressDemo();


                    break;

                case R.id.btn06:

                    showProgressDemo();

                    break;
                case R.id.btn07:
                    showCustomDemo();

                    break;

                case R.id.btn08:

                    showArrayAdapterDemo();


                    break;
            }

        }

        private void showArrayAdapterDemo() {
            final String[] items = {"篮球","足球","乒乓球","台球"};

//            数组适配器
//            1 环境
//            2 布局资源索引，指的是每一项数据所呈现的样式 android.R.layout.xx
//            3 数据源

//            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,items);

            // 给指定id的textView赋值
            ArrayAdapter adapter = new ArrayAdapter(DialogActivity.this,R.layout.array__item_layout,R.id.TxtView,items);

            AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this)
                    .setTitle("请选择")
                    .setAdapter(adapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,items[which],Toast.LENGTH_SHORT).show();

                        }
                    });

            builder.show();

        }

        private void showCustomDemo() {

            MyDialog dialog = new MyDialog(DialogActivity.this);

            dialog.show();

        }

        private void showProgressDemo() {

            final ProgressDialog dialog = new ProgressDialog(DialogActivity.this);

            dialog.setTitle("下载中");
            dialog.setMessage("请等待");
            dialog.setIndeterminate(true);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.show();
            new Thread() {

                @Override
                public void run(){
                    super.run();

                    for (int i = 1;i<100; i++){
                        dialog.setProgress(i);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                }

            }.start();




        }

        private void showWaitProgressDemo() {

            ProgressDialog dialog = new ProgressDialog(DialogActivity.this
            );
            dialog.setTitle("");
            dialog.setMessage("");
            dialog.show();

        }

        private void showMutiAlertDemo() {


            final String[] items = {"篮球","足球","乒乓球","台球"};
            final boolean[] checked= {true,false,false,true};
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this)
                    .setTitle("请选择")
                    .setMultiChoiceItems(items, checked, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            checked[which] = isChecked;
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String msg = "你的爱好是";

                            for (int j = 0;j<checked.length;j++) {

                                if (checked[j]){

                                    msg += items[j];
                                }
                            }

                            Toast.makeText(DialogActivity.this,msg,Toast.LENGTH_SHORT).show();
                        }
                    });

            builder.show();





        }


        int idx = 0;

        private void showSingleALertDemo() {

            final String[] items = {"我是一","我是二","我是三","我是四"};
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this)
                    .setTitle("请选择")
                    .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            idx = which;
//                            Toast.makeText(MainActivity.this,"你选择了" + items[which],Toast.LENGTH_SHORT).show();

                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(DialogActivity.this,"你选择了" + items[idx],Toast.LENGTH_SHORT).show();
                        }
                    });

            builder.show();

        }

        private void showListAlertDemo() {

            final String[] items = {"我是一","我是二","我是三","我是四"};
            AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this)
                    .setTitle("请选择")
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(DialogActivity.this,items[which],Toast.LENGTH_SHORT).show();

                        }
                    });
            builder.show();







        }


        private void AlertDemo01() {
//            要利用构造器
            AlertDialog.Builder buiddle = new AlertDialog.Builder(DialogActivity.this);

            buiddle.setTitle("提示").setMessage("你是否确定退出").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DialogActivity.this.finish();
                }
            }).setNegativeButton("取消",null).show();
        }


        private void AlertDemo() {

            AlertDialog alertDialog = new AlertDialog.Builder(DialogActivity.this).create();

            alertDialog.setTitle("提示");

            alertDialog.setMessage("请为我打分");

            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "5分", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(DialogActivity.this,"5分",Toast.LENGTH_SHORT).show();
                }
            });


            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "3分", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(DialogActivity.this,"3分",Toast.LENGTH_SHORT).show();
                }
            });


            alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "1分", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(DialogActivity.this,"1分",Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();

        }



    }

}
