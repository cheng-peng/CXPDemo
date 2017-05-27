package com.cxp.h5_scheme;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * cxp://cxp521.com:80/test?name=CXP&page=10
 * 打开这个页面
 */
public class SchemeActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);
        tv = (TextView) findViewById(R.id.tv);

        Uri uri = getIntent().getData();
        StringBuilder sb = new StringBuilder();
        // 唤起链接
        sb.append("string : ").append(getIntent().getDataString()).append("\n");
        sb.append("scheme : ").append(uri.getScheme()).append("\n");
        sb.append("host : ").append(uri.getHost()).append("\n");
        sb.append("port : ").append(uri.getPort()).append("\n");
        sb.append("path : ").append(uri.getPath()).append("\n");
        // 接收唤起的参数
        sb.append("name : ").append(uri.getQueryParameter("name")).append("\n");
        sb.append("page : ").append(uri.getQueryParameter("page"));

        tv.setText(sb.toString());

    }
}
