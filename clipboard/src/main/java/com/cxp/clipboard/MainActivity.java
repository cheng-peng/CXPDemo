package com.cxp.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 检测剪切板 简单用法
 * Text newPlainText(label, text) 	返回ClipData对象，其中ClipData.Item对象包含一个String
 * URI newUri(resolver, label, URI) 	返回ClipData对象，其中ClipData.Item对象包含一个URI
 * Intent newIntent(label, intent) 	返回ClipData对象，其中ClipData.Item对象包含一个Intent
 * getPrimaryClip() 	返回剪贴板上的当前Copy内容
 * getPrimaryClipDescription() 	返回剪贴板上的当前Copy的说明
 * hasPrimaryClip() 	如果当前剪贴板上存在Copy返回True
 * setPrimaryClip(ClipData clip) 	设置剪贴板上的当前Copy
 * setText(CharSequence text) 	设置文本到当前Copy
 * getText() 	获取剪贴板复制的文本
 */
public class MainActivity extends AppCompatActivity {

    private ClipboardManager mClipboardManager;
    private ClipData mClipData;

    private EditText mEtCopy;
    private EditText mEtPaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        //检测剪切板改变监听  （我也不知道为什么执行两次，有待研究）
        mClipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                ClipData abc = mClipboardManager.getPrimaryClip();
                ClipData.Item item = abc.getItemAt(0);
                String text = item.getText().toString();
                if (text!=null) {
                    if (text.equals("CXP")) {
                        Toast.makeText(MainActivity.this,"程小鹏这个人好啊!",Toast.LENGTH_SHORT).show();
                    }
                }

//                if (text != null) {
//                    //剪切板是文字
//                    return;
//                } else {
//                    Uri pasteUri = item.getUri();
//                    if (pasteUri != null) {
//                        //剪切板是Uri
//                        return;
//                    } else {
//                        Intent intent = item.getIntent();
//                        //剪切板是Intent
//                        return;
//                    }
//                }
            }
        });
        mEtCopy = (EditText) findViewById(R.id.main_et1);
        mEtPaste = (EditText) findViewById(R.id.main_et2);

    }

    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.main_bt1:
                //复制
                copy();
                break;
            case R.id.main_bt2:
                //粘贴
                paste();
                break;
        }
    }

    //复制
    private void copy() {
        String text = mEtCopy.getText().toString();
        mClipData = ClipData.newPlainText("text", text);
        mClipboardManager.setPrimaryClip(mClipData);
        Toast.makeText(getApplicationContext(), "复制成功", Toast.LENGTH_LONG).show();
    }

    //粘贴
    private void paste() {
        ClipData abc = mClipboardManager.getPrimaryClip();
        ClipData.Item item = abc.getItemAt(0);
        String text = item.getText().toString();
        mEtPaste.setText(text);
        Toast.makeText(getApplicationContext(), "粘贴成功",
                Toast.LENGTH_SHORT).show();
    }

}
