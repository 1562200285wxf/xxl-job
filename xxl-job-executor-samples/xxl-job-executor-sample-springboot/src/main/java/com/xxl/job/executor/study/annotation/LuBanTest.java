package com.xxl.job.executor.study.annotation;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-21 11:31
 * @description：
 */
public class LuBanTest {
    public static void main(String[] args) {
       LuBanDao daoProxy =  (LuBanDao) LuBanProxyFactory.getDao(LuBanDao.class);
        daoProxy.query();
    }
}
