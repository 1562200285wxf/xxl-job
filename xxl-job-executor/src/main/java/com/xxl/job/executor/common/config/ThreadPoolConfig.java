package com.xxl.job.executor.common.config;

import com.xxl.job.executor.common.handler.CustomRejectionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池配置
 *
 * @author wangxiaofeng
 */
@Configuration
@Slf4j
@EnableAsync
public class ThreadPoolConfig {

    //按照CPU核数的一般设置
    @Value("${asyncThreadPool.corePoolSize:2}")
    private int corePoolSize;

    //按照核数的两倍设置--在高峰阶段尽可能压榨CPU
    @Value("${asyncThreadPool.maxPoolSize:4}")
    private int maxPoolSize;

    @Value("${asyncThreadPool.queueCapacity:2}")
    private int queueCapacity;

    //一般设置为一分钟
    @Value("${asyncThreadPool.keepAliveSeconds:60}")
    private int keepAliveSeconds;

//    @Value("${asyncThreadPool.awaitTerminationSeconds:5}")
//    private int awaitTerminationSeconds;

    @Value("${asyncThreadPool.threadNamePrefix:thread----->}")
    private String threadNamePrefix;

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        log.info("---------- 线程池开始加载 ----------");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程池大小
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        // 最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        /* 队列
            LinkedBlockingQueue 默认使用无边界的阻塞队列
            ArrayBlockingQueue 有边界队列
            PriorityBlockingQueue  任务优先级队列
        */
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        // 活跃时间---
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        // 主线程等待子线程执行时间---也有可能是拒绝策略
//        threadPoolTaskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        // 线程名字前缀
        threadPoolTaskExecutor.setThreadNamePrefix(threadNamePrefix);
        // 自定义拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new CustomRejectionHandler());
        // 初始化
        threadPoolTaskExecutor.initialize();
        log.info("---------- 线程池加载完成 ----------");
        return threadPoolTaskExecutor;
    }

}
