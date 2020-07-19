package com.lfj.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *  自定义线程池拒绝策略
 */
public class CustomThreadPoolRejected implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue(100);
        arrayBlockingQueue.add(r);

    }
}
