package com.cxp.espresso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt= (Button) findViewById(R.id.main_bt);
    }

    public void clickLis(View view){
        Toast.makeText(MainActivity.this,"点我干啥啊！！！",Toast.LENGTH_SHORT).show();
    }
}
