package com.cxp.h5_scheme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 文 件 名: JSActivity
 * 创 建 人: CXP
 * 创建日期: 2017-01-17 11:21
 * 描    述: Js 与Java 交互
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class JSActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;
    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        mEditText = (EditText) findViewById(R.id.main_et);
        mButton = (Button) findViewById(R.id.main_bt);
        mWebView = (WebView) findViewById(R.id.main_web);

        mWebView.loadUrl("file:///android_asset/android.html");
        //js操作java
        mWebView.addJavascriptInterface(new JSInterface(), "Android");
        //不跳转到其他浏览器
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        //支持js
        mWebView.getSettings().setJavaScriptEnabled(true);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //java调用JS方法
                mWebView.loadUrl("javascript:javaCallJs(" + "'" + mEditText.getText().toString() + "'" + ")");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.stopLoading();
        mWebView.removeAllViews();
        mWebView.destroy();
        mWebView = null;
    }

    class JSInterface {
        //JS需要调用的方法
        @JavascriptInterface
        public void showToast(String arg) {
            Toast.makeText(JSActivity.this, arg, Toast.LENGTH_SHORT).show();
        }
    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent=new Intent(context,JSActivity.class);
        context.startActivity(intent);
    }
}

