package com.example.liushaohua02.androiddemolist.UISetting;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

public class ActivityMenu extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 创建contextMenu
        // 1 注册
        // 2 创建 覆盖onCreateContextMenu
        // 3 菜单项的操作 覆盖onContextItemSelected
//         4 为按钮设置上下文操作模式
        // 4.1 实现ActionMode Callback 方法
//        4、2 在View的长安时间中去启动上下文操作模式

        registerForContextMenu(findViewById(R.id.button_menu_01));
        findViewById(R.id.button_menu_01).setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                startActionMode(cb);
                return false;
            }
        });


        // popmenu

        final Button popupBtn = findViewById(R.id.button_menu_02);

        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1实例化popmenu对象
                PopupMenu menu = new PopupMenu(ActivityMenu.this,popupBtn);
                // 2 加载菜单资源 利用menuinflater 将menu资源加载到popupMenu.getMenu
                // 将menu。xx对于的菜单资源加载到弹出式菜单中
                menu.getMenuInflater().inflate(R.menu.popup,menu.getMenu());

                // 3 为popupmenu设置监听器
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(ActivityMenu.this,""+ item.getTitle(),Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                // 4 展示
                menu.show();
            }
        });
    }


    ActionMode.Callback cb = new ActionMode.Callback() {
        // 创建，在启动上下文操作模式（startActionModel（CallBack））时调用
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Log.e("Tag","创建");
            getMenuInflater().inflate(R.menu.contextmenu,menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Log.e("Tag","准备");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Log.e("Tag","点击");
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            Log.e("Tag","结束");

        }
    };


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.click :

                Toast.makeText(ActivityMenu.this,"点击",Toast.LENGTH_SHORT).show();
                break;

            case R.id.choose :
                Toast.makeText(ActivityMenu.this,"选择",Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onContextItemSelected(item);
    }




    // 创建optionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // xml设置optionMenu
        getMenuInflater().inflate(R.menu.option,menu);

        // java代码设置

        // 必须返回true
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save :

                Toast.makeText(ActivityMenu.this,"保存",Toast.LENGTH_SHORT).show();
                break;

            case R.id.setting :
                Toast.makeText(ActivityMenu.this,"设置",Toast.LENGTH_SHORT).show();

                break;

            case R.id.exit :
                Toast.makeText(ActivityMenu.this,"退出",Toast.LENGTH_SHORT).show();

                finish();
                break;
            // 养成好习惯 在default中重写父类方法
            default:
                super.onOptionsItemSelected(item);

        }

        return true;
    }


}
