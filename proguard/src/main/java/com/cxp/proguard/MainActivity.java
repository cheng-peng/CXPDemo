package com.cxp.proguard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_bt)
    Button mainBt;
    private String toastTip = "toast in MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().add(R.id.main_bt, new MyFragment()).commit();
    }

    public void methodWithGlobalVariable() {
        Toast.makeText(MainActivity.this, toastTip, Toast.LENGTH_SHORT).show();
    }

    public void methodWithLocalVariable() {
        String logMessage = "log in MainActivity";
        logMessage = logMessage.toLowerCase();
        System.out.println(logMessage);
    }

    @OnClick(R.id.main_bt)
    public void onClick() {
        methodWithGlobalVariable();
        methodWithLocalVariable();
        Utils utils = new Utils();
        utils.methodNormal();
        NativeUtils.methodNative();
        NativeUtils.methodNotNative();
        Connector.getDatabase();
    }
}
