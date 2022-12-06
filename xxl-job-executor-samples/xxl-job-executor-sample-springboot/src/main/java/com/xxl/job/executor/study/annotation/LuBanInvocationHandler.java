package com.xxl.job.executor.study.annotation;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 11:21
 * @description：去做被代理接口的通用实现
 */
public class LuBanInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始进行数据库链接");
        String var = method.getAnnotation(Select.class).value()[0];
        System.out.println("------------执行SQL"+var);
        return null;
    }
}
