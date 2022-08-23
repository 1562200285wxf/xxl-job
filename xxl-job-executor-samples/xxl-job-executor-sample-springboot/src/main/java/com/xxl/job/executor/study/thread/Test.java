package com.xxl.job.executor.study.thread;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-23 16:51
 * @description：
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.t1();
            }
        },"thread1").start();

        Test test1 = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.t2();
            }
        },"thread2").start();
    }

    synchronized void t1(){
        System.out.println(Thread.currentThread().getName());
        t2();
    }

    synchronized void t2(){
        System.out.println(Thread.currentThread().getName());
    }
}
