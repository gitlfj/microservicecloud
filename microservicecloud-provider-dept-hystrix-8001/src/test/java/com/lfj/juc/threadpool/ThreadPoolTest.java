package com.lfj.juc.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  java创建多线程的第四种方式线程池
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();


        for (int i = 1 ; i<=10 ; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 线程处理任务");
            });

            executorService.submit(() -> {

            });
        }

    }


}
