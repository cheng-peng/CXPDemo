package com.cxp.proguard;

/**
 * Created by CXP on 2016/12/29
 * desc :
 * q978515743@163.com
 */

public class Utils {

    public void methodNormal() {
        String logMessage = "this is normal method";
        logMessage = logMessage.toLowerCase();
        System.out.println(logMessage);
    }

    public void methodUnused() {
        String logMessage = "this is unused method";
        logMessage = logMessage.toLowerCase();
        System.out.println(logMessage);
    }

}
