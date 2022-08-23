package com.xxl.job.executor.common.config;


import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-22 23:26
 * @description：线程池执行
 */

public class MyThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    Logger logger = LoggerFactory.getLogger(MyThreadPoolTaskExecutor.class);

    @Override
    public void execute(Runnable task) {
        logThreadPoolStatus();
        super.execute(task);
    }

    @Override
    public Future<?> submit(Runnable task) {
        logThreadPoolStatus();
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        logThreadPoolStatus();
        return super.submit(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(Runnable task) {
        logThreadPoolStatus();
        return super.submitListenable(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        logThreadPoolStatus();
        return super.submitListenable(task);
    }

    /**
     * 在线程池运行的时候输出线程池的基本信息
     */
    private void logThreadPoolStatus() {
        logger.info("核心线程数:{}, 最大线程数:{}, 当前线程数: {}, 活跃的线程数: {}",
                getCorePoolSize(), getMaxPoolSize(), getPoolSize(), getActiveCount());
    }
}

