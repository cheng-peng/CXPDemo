package com.cxp.uiautomator;

import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;

/**
 * Created by CXP on 2017/1/6
 * desc : 计算机Demo  自动化测试
 * q978515743@163.com
 */

public class CalculatorAndroidTest extends UiAutomatorTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        UiDevice device = getUiDevice();
        device.pressHome();
        UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
        allAppsButton.clickAndWaitForNewWindow();
        UiObject cal = new UiObject(new UiSelector().text("Calculator"));
        cal.click();
    }

    @Test
    public void testSum() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().text("9")).click();
        new UiObject(new UiSelector().text("+")).click();
        new UiObject(new UiSelector().text("1")).click();
        new UiObject(new UiSelector().text("=")).click();

        UiObject res = new UiObject(new UiSelector().className("android.widget.EditText"));
        assertEquals("","10",res.getText());
    }

    @Test
    public void testSub() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().text("9")).click();
        new UiObject(new UiSelector().text("−")).click();
        new UiObject(new UiSelector().text("1")).click();
        new UiObject(new UiSelector().text("=")).click();

        UiObject res = new UiObject(new UiSelector().className("android.widget.EditText"));
        assertEquals("","8",res.getText());
    }

    @Test
    public void testMul() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().text("3")).click();
        new UiObject(new UiSelector().text("×")).click();
        new UiObject(new UiSelector().text("4")).click();
        new UiObject(new UiSelector().text("=")).click();

        UiObject res = new UiObject(new UiSelector().className("android.widget.EditText"));
        assertEquals("","12",res.getText());
    }

    @Test
    public void testDiv() throws UiObjectNotFoundException {
        new UiObject(new UiSelector().text("9")).click();
        new UiObject(new UiSelector().text("÷")).click();
        new UiObject(new UiSelector().text("3")).click();
        new UiObject(new UiSelector().text("=")).click();

        UiObject res = new UiObject(new UiSelector().className("android.widget.EditText"));
        assertEquals("","3",res.getText());
    }
}
