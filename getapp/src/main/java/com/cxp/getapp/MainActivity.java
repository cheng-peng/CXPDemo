package com.cxp.getapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

    }

    public void appInfo_all() {
        List<AppInfo> appList = new ArrayList<AppInfo>();
        ApplicationInfoUtil.getAllProgramInfo(appList, this);
        ListActivity.startActivity(mContext, appList);
    }

    public void appInfo_system() {
        List<AppInfo> systemAppList = ApplicationInfoUtil.getAllSystemProgramInfo(this);
        ListActivity.startActivity(mContext, systemAppList);
    }

    public void appInfo_nonsystem() {
        List<AppInfo> nonsystemAppList = ApplicationInfoUtil.getAllNonsystemProgramInfo(this);
        ListActivity.startActivity(mContext, nonsystemAppList);
    }

    //单击事件
    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                new Thread(){
                    @Override
                    public void run() {
                        //获取所有应用信息
                        appInfo_all();
                    }
                }.start();
                break;
            case R.id.bt2:
                new Thread(){
                    @Override
                    public void run() {
                        //获取系统应用信息
                        appInfo_system();
                    }
                }.start();
                break;
            case R.id.bt3:
                new Thread(){
                    @Override
                    public void run() {
                        //获取非系统应用信息
                        appInfo_nonsystem();
                    }
                }.start();
                break;
        }
    }
}
