package com.xxl.job.executor.study.proxy;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 14:45
 * @description：
 */
public class InterServiceProxy implements InterService{

    InterServiceProxy(InterService interService){
        this.target = interService;
    }
    InterService target;
    @Override
    public void query() {
        System.out.println("InterServiceProxy");
        target.query();
    }
}
