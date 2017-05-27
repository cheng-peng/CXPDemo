package com.cxp.h5_scheme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * 文 件 名: WebViewActivity
 * 创 建 人: CXP
 * 创建日期: 2017-01-17 11:48
 * 描    述: WebView用法
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class WebViewActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;
    private WebView mWebView;
    private String path = "";

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        mContext = WebViewActivity.this;

        mEditText = (EditText) findViewById(R.id.main_et);
        mButton = (Button) findViewById(R.id.main_bt);
        mWebView = (WebView) findViewById(R.id.main_web);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditText.getText() != null && mEditText.getText().toString().trim().length() != 0) {
                    path = mEditText.getText().toString();
                }
                //初始化WebView
                initWebView(path);
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

    //初始化WebView
    private void initWebView(String path) {

        if (path != null && path.trim().length() != 0) {
            //加载网络资源(注意要加上网络权限,前面必须有协议 例如：http://)
            if (path.indexOf("http") == -1) {
                mWebView.loadUrl("http://" + path);
            } else {
                mWebView.loadUrl(path);
            }
        } else {
            //加载assets目录下的index.html文件
            mWebView.loadUrl("file:///android_asset/index.html");
        }


        //在WebView打开新页面  （默认在本机浏览器打开，多个浏览器，会让你进行选择）  百度会加载两次  测试网址：http://www.52pojie.cn/
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                //true 拦截页面跳转 建议false
                return false;
            }

        });

        //替换网站logo图片
//        mWebView.setWebViewClient(new WebViewClient(){
//            @Override
//            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
//                WebResourceResponse response = null;
//                if (url.contains("logo")) {
//                    try {
//                        InputStream logo = getAssets().open("cxp_logo.png");
//                        response = new WebResourceResponse("image/png", "UTF-8", logo);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return response;
//            }
//        });

        //设置开始加载网页、加载完成、加载错误时处理
//        mWebView.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//                // 开始加载网页时处理 如：显示"加载提示" 的加载对话框
//                Log.e("CXP","加载中...");
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                // 网页加载完成时处理  如：让 加载对话框 消失
//                Log.e("CXP","加载完成");
//            }
//
//            @Override
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                super.onReceivedError(view, errorCode, description, failingUrl);
//                // 加载网页失败时处理 如：提示失败，或显示新的界面
//                Toast mToast = Toast.makeText(mContext, "加载失败", Toast.LENGTH_SHORT);
//            }
//        });

        //处理https请求
//        mWebView.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                handler.proceed();  // 接受信任所有网站的证书
////                 handler.cancel();   // 默认操作 不处理
//                // handler.handleMessage(null);  // 可做其他处理
//            }
//        });

        //level 21使用以下方案
//        mWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                view.loadUrl(request.getUrl().toString());
//                return true;
//            }
//        });

        //显示页面加载进度
//        mWebView.setWebChromeClient(new WebChromeClient() {
//
//            public void onProgressChanged(WebView view, int progress) {
//                setTitle("页面加载中，请稍候..." + progress + "%");
//                setProgress(progress * 100);
//                Log.e("CXP",""+progress);
//                if (progress == 100) {
//                    Log.e("CXP","SUCCESS");
//                }
//            }
//        });
    }

    //返回上一浏览页面 ,不是退出程序
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        //其中webView.canGoBack()在webView含有一个可后退的浏览记录时返回true
//
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
//            mWebView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    //页面跳转
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, WebViewActivity.class);
        context.startActivity(intent);
    }
}
