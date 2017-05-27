package com.cxp.getapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/**
 * 文 件 名: AppInfo
 * 创 建 人: CXP
 * 创建日期: 2017-04-08 18:07
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class AppInfo {

    public String appName ; // 应用名
    public String packageName ; // 包名
    public String versionName ; // 版本名
    public int versionCode = 0; // 版本号
    public Drawable appIcon = null; // 应用图标
    public Intent intent = null; // APP启动

    @Override
    public String toString() {
        return appName+" , "+packageName+" ,"+versionName+" ,"+versionCode;
    }
}
