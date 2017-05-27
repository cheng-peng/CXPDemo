package com.cxp.espresso;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by CXP on 2016/12/30
 * desc :
 * q978515743@163.com
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void demo() {
        /**
         * 找寻元素
         * 查找的数必须是唯一的，否则会出错
         * onView(withText("Hello World!"))    根据指定文本来找寻控件
         * onView(withId(R.id.activity_main))  根据指定ID来找寻控件
         * onView(allOf(withId(R.id.activity_main), not(withText("Unwanted"))));
         * perform(click(),clearText()) 执行什么操作  可以执行多个或者单个
         * check(matches(withText("点我"))) 检测
         */
        onView(withId(R.id.main_bt)).perform(click());
        onView(withId(R.id.main_bt)).check(matches(withText("点我")));
//        onView(allOf(withId(R.id.activity_main), not(withText("Unwanted"))));
    }
}
