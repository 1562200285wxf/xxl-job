package com.xxl.job.executor.study.proxy;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 14:38
 * @description： 继承类实现代理
 */
public class IndexServiceExtendProxy extends IndexService{
    @Override
    public void query(){
        System.out.println("IndexServiceExtendProxy");
        super.query();
    }
}
