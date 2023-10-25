package com.bread.coalquality.sys.threadpool;



import com.bread.coalquality.sys.threadpool.queue.AsyncServiceBlockingQueue;
import com.bread.coalquality.sys.threadpool.queue.CsutomServiceBlockingQueue;
import com.bread.coalquality.sys.threadpool.reject.Wait60sThreadRejectHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author haoxd
 * @description: 系统线程池配置
 */
@Configuration
@EnableAsync
@Slf4j
public class ThreadPoolProviderConfig {


    private static final int POOL_SIZE = ThreadUtil.getSuitableThreadCount();

    private static final BlockingQueue<Runnable> ASYNC_SERVICE_QUEUE = new AsyncServiceBlockingQueue().generateBlockingQueue();

    private static final BlockingQueue<Runnable> CUSTOM_SERVICE_QUEUE = new CsutomServiceBlockingQueue().generateBlockingQueue();

    private static final RejectedExecutionHandler CUSTOM_REJECT_HANDLER = new Wait60sThreadRejectHandler().generateRejected();

    private static final RejectedExecutionHandler CALLERRUNSPOLICY_HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();


    /**
     * 异步任务线程池，当达到线程池最大处理能力后，后续加入的工作线程将 等待60S
     */
    @Bean(name = "asyncServiceExecutor")
    public ThreadPoolExecutor asyncServiceExecutor() {
        return new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE << 1,
                60, TimeUnit.SECONDS, ASYNC_SERVICE_QUEUE, new ThreadPoolThreadFactory("async-service-"), CUSTOM_REJECT_HANDLER);
    }



    /**
     * 异步任务线程池，当达到线程池最大处理能力后，后续加入的工作线程将任务提交到提交任务的线程自己去执行该任务。
     */
    @Bean(name = "customServiceExecutor")
    public ThreadPoolExecutor customServiceExecutor() {
        return new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE << 1,
                60, TimeUnit.SECONDS, CUSTOM_SERVICE_QUEUE, new ThreadPoolThreadFactory("custom-service-"), CALLERRUNSPOLICY_HANDLER);
    }

}
