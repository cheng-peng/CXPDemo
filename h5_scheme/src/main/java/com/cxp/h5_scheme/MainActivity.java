package com.cxp.h5_scheme;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * WebView使用详解
 */
public class MainActivity extends AppCompatActivity {

    private Button btWebView;
    private Button btJsDemo;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        btWebView = (Button) findViewById(R.id.bt_web);
        btJsDemo = (Button) findViewById(R.id.bt_js_demo);

        btWebView.setOnClickListener(clickLis);
        btJsDemo.setOnClickListener(clickLis);

    }

    //单击事件
    private View.OnClickListener clickLis = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_web:
                    //WebView用法
                    WebViewActivity.startActivity(mContext);
                    break;
                case R.id.bt_js_demo:
                    //Js 与Java 交互 demo
                    JSActivity.startActivity(mContext);
                    break;
            }
        }
    };
}
