package com.cxp.lambda;

/**
 * @author CXP
 * @desc demo2使用的接口
 * @time 2017/1/12 16:42
 * @email q978515743@163.com
 */

public interface Factory<T extends User> {
    T create(String name, int age);
}
