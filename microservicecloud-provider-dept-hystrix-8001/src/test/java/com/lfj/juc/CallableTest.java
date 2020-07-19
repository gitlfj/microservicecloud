package com.lfj.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("come in call......,  ThreadName: " + Thread.currentThread().getName());
        Thread.sleep(5000);
        return 20;
    }
}

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "lfj thread ").start();
        Integer result2 = futureTask.get();

        System.out.println(Thread.currentThread().getName() + "_*****");
        Integer result1 = 1000;
        System.out.println(result1 + result2);

        // 查看电脑CUP核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
