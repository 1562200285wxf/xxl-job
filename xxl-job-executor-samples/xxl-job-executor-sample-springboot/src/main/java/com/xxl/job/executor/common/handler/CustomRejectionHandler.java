package com.xxl.job.executor.common.handler;

import lombok.extern.slf4j.Slf4j;

import javax.tools.JavaCompiler;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022/3/15 16:23
 * @description：
 */
@Slf4j
public class CustomRejectionHandler implements RejectedExecutionHandler {

    //创建线程池的啥时候可以进行拒绝策略的修改---非重要服务可以选择入库--重要环节选择（返回主线程执行并记录）
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.info("超过最大线程---拒绝之后的子线程执行");
        //  todo 入库操作
        //模拟  CallerRunsPolicy拒绝策略，使用主线程执行任务
        if (!executor.isShutdown()) {
            r.run();
        }

        System.out.println(r.toString() + "线程被拒绝，请查询");
    }
}
