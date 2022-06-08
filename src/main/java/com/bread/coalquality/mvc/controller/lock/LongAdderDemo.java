package com.bread.coalquality.mvc.controller.lock;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.LongAdder;

/**
 * <pre>
 * 程序目的：和 AtomicLong 进行性能对比
 * </pre>
 * created at 2020/8/11 06:25
 *在每个线程执行的累加数量变多时，LongAdder比AtomicLong性能优势越发明显。

 LongAdder由于采用了分段理念，降低了线程间的竞争冲突，而AtomicLong却因多个线程并行竞争同一个value值，从而影响了性能。

 在低竞争的情况下，AtomicLong 和 LongAdder 这两个类具有相似的特征，吞吐量也是相似的，因为竞争不高。

 但是在竞争激烈的情况下，LongAdder 的预期吞吐量要高得多，经过试验，LongAdder 的吞吐量大约是 AtomicLong 的十倍，不过凡事总要付出代价，LongAdder 在保证高效的同时，也需要消耗更多的空间。
 * @author lerry
 */
public class LongAdderDemo {
    /**
     * 线程池内线程数
     */
    final static int POOL_SIZE = 1000;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        LongAdder counter = new LongAdder();
        ExecutorService service = Executors.newFixedThreadPool(POOL_SIZE);

        ArrayList<Future> futures = new ArrayList<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE * 100; i++) {
            futures.add(service.submit(new LongAdderDemo.Task(counter)));
        }

        // 等待所有线程执行完
        for (Future future : futures) {
            try {
                future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        NumberFormat numberFormat = NumberFormat.getInstance();
        System.out.printf("统计结果为：[%s]\n", numberFormat.format(counter.sum()));
        System.out.printf("耗时：[%d]毫秒", (System.currentTimeMillis() - start));
        // 关闭线程池
        service.shutdown();
    }

    /**
     * 有一个 LongAdder 成员变量，每次执行N次+1操作
     */
    static class Task implements Runnable {

        private final LongAdder counter;

        public Task(LongAdder counter) {
            this.counter = counter;
        }

        /**
         * 每个线程执行N次+1操作
         */
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }// end run
    }// end class
}