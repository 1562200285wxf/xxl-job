package com.xxl.job.executor.study.thread;

import javafx.application.Application;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-26 0:00
 * @description：ThreadLocal 修饰的对象在不同线程之间互不影响
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        String name = "212";
        ThreadLocal<Apple> threadLocal = new ThreadLocal<>();
        new Thread(() ->{
            try {
                Apple apple = new Apple("size");
                threadLocal.set(apple);
                Thread.sleep(2000);
                System.out.println(threadLocal.get());
            }catch (InterruptedException interruptedException){
            }
        },"t1").start();
        new Thread(() ->{
            try {
                Thread.sleep(1000);
                threadLocal.set(new Apple("color"));
            }catch (InterruptedException interruptedException){
            }
            System.out.println(threadLocal.get());
        },"t2").start();

    }

    static class Apple{


        Apple(String type){
            name = type;
        }
        String name = "color";

        @Override
        public String toString() {
            return "Apple{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
