package com.xxl.job.executor.study.proxy;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 14:45
 * @description：
 */
public class InterServiceProxy1 implements InterService{

    InterServiceProxy1(InterService interService){
        this.target = interService;
    }
    InterService target;
    @Override
    public void query() {
        System.out.println("InterServiceProxy1");
        target.query();
    }
}
