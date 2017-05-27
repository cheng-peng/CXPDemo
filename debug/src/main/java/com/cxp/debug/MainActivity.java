package com.cxp.debug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化数据
        initDatas();
    }

    //初始化数据
    private void initDatas() {
        for (int i = 0; i < 20; i++) {
            String str = "" + (char) (65 + i);
            Log.e("CXP",str);
        }
    }
}
