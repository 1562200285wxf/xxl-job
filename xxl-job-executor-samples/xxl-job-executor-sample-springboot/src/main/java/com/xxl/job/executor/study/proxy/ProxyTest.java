package com.xxl.job.executor.study.proxy;

import sun.plugin2.applet.Applet2ClassLoader;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 14:39
 * @description：
 */
public class ProxyTest {
    public static void main(String[] args) {
//        IndexService indexService = new IndexServiceExtendProxy();
//        indexService.query();
        System.out.println("=========");
        InterService interService = new InterServiceProxy1(new InterServiceImpl());
        InterService interService1 = new InterServiceProxy(interService);
        interService1.query();
    }
}
