package com.xxl.job.executor.study.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-22 15:12
 * @description：生命周期初始化回调函数:基于后置处理器进行开发的
 */
@Component
public class CallBackBean implements InitializingBean {

    private CallBackBean(){
        //构造方法会在当前bean对象被加载为spring bean实例的时候运行。
        System.out.println("------------构造方法初始化---------");
    }

    @PostConstruct
    public void post(){
        //此时已经完成了spring bean对象的加载
        System.out.println("------------------PostConstruct---------------------------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---------------------InitializingBean：初始化-----------------");
    }
}
