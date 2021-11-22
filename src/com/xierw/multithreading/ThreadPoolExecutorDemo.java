package com.xierw.multithreading;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    /**
     * 核心线程
     */
    private static final int CORE_POOL_SIZE = 5;
    /**
     * 最大线程
     */
    private static final int MAXIMUM_POOL_SIZE = 10;
    /**
     * 任务队列
     */
    private static final int QUEUE_CAPACITY = 5;
    /**
     * 无任务时线程存活时间
     */
    private static final Long KEEP_ALIVE_TIME = 10L;
    /**
     * 时间的单位
     */
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    /**
     * 工作队列：数组类型
     */
    private static final BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    /**
     * 默认的线程工厂
     */
    private static final ThreadFactory THREAD_FACTORY = Executors.defaultThreadFactory();
    /**
     * 当线程池满时，只要线程池未关闭，让调用execute方法的线程执行该任务
     */
    private static final RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();


    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TIME_UNIT,
                WORK_QUEUE,
                THREAD_FACTORY,
                HANDLER);
        //创建16个任务，5个进队列，10线程池执行，1个被拒绝策略让main线程执行
        for (int i = 0; i < 16; i++) {
            MyRunnable runnable = new MyRunnable(""+i);
            executor.execute(runnable);
        }

        //终止线程池接受新任务,已有的线程继续运行
        executor.shutdown();
        while (!executor.isTerminated()){}
        System.out.println("Finished all threads!");
    }
}
