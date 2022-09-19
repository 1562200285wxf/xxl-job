package com.xxl.job.executor.study.thread;


import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-24 23:23
 * @description：线程通信模型： 线程t2对容器添加元素，当i=5的时候，通知线程t1
 */
public class TwoThreadCommun {

    volatile static Set<Object> set = new HashSet<>();

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() ->{
            synchronized (lock){
                while (set.size()!=5){
                    try {
                        lock.wait();
                        System.out.println("进行提示--------》:set.size="+set.size());
                    }catch (Exception e){

                    }
                }
                lock.notify();
                System.out.println("t1释放锁");
            }
        },"t1").start();


        new Thread((() ->{
            synchronized (lock){
                try {
                    for (int i = 1; i < 11; i++) {
                        System.out.println("set.size ====="+set.size());
                        set.add(new Object());
                        if(i == 5){
                            lock.notify();
                            try {
                                System.out.println("t2准备wait");
                                lock.wait();
                                System.out.println("t2准备wait结束");
                            }catch (Exception e){
                            }
                        }
                    }
                    System.out.println("t2执行结束");
                }catch (Exception e){
                }
            }
        }),"t2").start();
    }
}
