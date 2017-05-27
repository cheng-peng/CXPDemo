package com.cxp.proguard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by CXP on 2016/12/28
 * desc :
 * q978515743@163.com
 */

public class MyFragment extends Fragment {

    private String toastTip = "toast in MyFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        methodWithGlobalVariable();
        methodWithLocalVariable();
        return view;
    }

    public void methodWithGlobalVariable() {
        Toast.makeText(getActivity(), toastTip, Toast.LENGTH_SHORT).show();
    }

    public void methodWithLocalVariable() {
        String logMessage = "log in MyFragment";
        logMessage = logMessage.toLowerCase();
        System.out.println(logMessage);
    }

}
