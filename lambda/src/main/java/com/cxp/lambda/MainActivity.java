package com.cxp.lambda;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;

        bt= (Button) findViewById(R.id.main_bt);
        //原始写法
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContext,"点我干啥！",Toast.LENGTH_SHORT).show();
//            }
//        });
        //Lambda写法
        bt.setOnClickListener(( view)-> Toast.makeText(mContext,"点我干啥！",Toast.LENGTH_SHORT).show());
    }
}
