package com.cxp.proguard;

/**
 * Created by CXP on 2016/12/29
 * desc :
 * q978515743@163.com
 */

public  class NativeUtils {
    public static native void methodNative();

    public static void methodNotNative() {
        String logMessage = "this is not native method";
        logMessage = logMessage.toLowerCase();
        System.out.println(logMessage);
    }

}
