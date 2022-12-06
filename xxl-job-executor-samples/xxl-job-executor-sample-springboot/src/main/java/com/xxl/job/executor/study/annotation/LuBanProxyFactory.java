package com.xxl.job.executor.study.annotation;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.DependsOn;

import java.lang.reflect.Proxy;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 11:20
 * @description：
 */
public class LuBanProxyFactory {

    public static Object getDao(Class clazz){

        Class[] classes = new Class[]{clazz};
        Object o = Proxy.newProxyInstance(LuBanDaoImpl.class.getClassLoader(),classes,new LuBanInvocationHandler());
        return o;


    }
}
