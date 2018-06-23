package com.example.liushaohua02.androiddemolist.GridView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.GridView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.GridView.Adaptor.GridAdaptor02;
import com.example.liushaohua02.androiddemolist.GridView.Model.AppInfo;
import com.example.liushaohua02.androiddemolist.R;

import java.util.ArrayList;
import java.util.List;

public class GridActiovity02 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_actiovity02);

        GridView gridView = findViewById(R.id.gridVie02);

        gridView.setAdapter(new GridAdaptor02(this,getAppInfo()));
    }

    /*
     * 获取数据源
     * */
    public List<AppInfo> getAppInfo(){

        List<AppInfo>appInfoList = new ArrayList<AppInfo>();
        PackageManager packageManager = getPackageManager();

        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);

        for (int i = 0;i < installedPackages.size();i++){
            PackageInfo packageInfo = installedPackages.get(i);
            AppInfo appInfo = new AppInfo();
            appInfo.setAppName(packageInfo.applicationInfo.loadLabel(packageManager).toString());
            appInfo.setAppIcon(packageInfo.applicationInfo.loadIcon(packageManager));
            appInfo.setPackageName(packageInfo.packageName);
            appInfo.setVersionCode(packageInfo.versionCode);
            appInfo.setVersionName(packageInfo.versionName);

            // 排除系统自带的软件
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                appInfoList.add(appInfo);
            }
        }

        return appInfoList;
    }


}
