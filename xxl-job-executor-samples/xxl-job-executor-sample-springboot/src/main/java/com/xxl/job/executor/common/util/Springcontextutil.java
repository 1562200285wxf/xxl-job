package com.xxl.job.executor.common.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-22 16:28
 * @description：设置工厂类
 */
public class Springcontextutil {
    private static ConfigurableApplicationContext applicationcontext;
    //获取上下文
    public static ConfigurableApplicationContext getapplicationcontext() {
        return applicationcontext;
    }
    //设置上下文
    public static void setapplicationcontext(ConfigurableApplicationContext applicationcontext) {
        Springcontextutil.applicationcontext = applicationcontext;
    }
    //通过名字获取上下文中的bean
    public static Object getbean(String name){
        return applicationcontext.getBean(name);
    }
    //通过类型获取上下文中的bean
    public static Object getbean(Class<?> requiredtype){
        return applicationcontext.getBean(requiredtype);
    }
}
