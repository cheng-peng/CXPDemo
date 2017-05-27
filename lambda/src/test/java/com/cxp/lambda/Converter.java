package com.cxp.lambda;

/**
 * @author CXP
 * @desc 自定义接口
 * @time 2017/1/12 16:12
 * @email q978515743@163.com
 */
public interface Converter<F, T> {
    T convert(F from);
}
