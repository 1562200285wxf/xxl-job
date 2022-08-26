package com.xxl.job.executor.study.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-26 11:40
 * @description：两个线程交替打印两个数组
 */
public class LockSupportLockTest {
    private static String strs = "123456789";
    private static String strs2 = "qwertyuio";

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] chars1 = strs.toCharArray();
        char[] chars2 = strs2.toCharArray();
        t1 = new Thread(() ->{
            for (char c : chars1) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");
        t2  = new Thread(() ->{
            for (char c : chars2) {
                System.out.println(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
