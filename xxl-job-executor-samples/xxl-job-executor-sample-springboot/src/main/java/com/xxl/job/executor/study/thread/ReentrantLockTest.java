package com.xxl.job.executor.study.thread;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-23 16:51
 * @description：可重入锁测试
 */
public class ReentrantLockTest {
    public static void main(String[] args) {

        new Thread(new ReentrantLockTest()::t1).start();

        new ReentrantLock(true);

        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        Lock lock = new ReentrantLock();
        ReentrantLockTest test = new ReentrantLockTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.t1();
            }
        },"thread1").start();

        ReentrantLockTest test1 = new ReentrantLockTest();
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
