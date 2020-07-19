package com.lfj.juc;

import java.util.concurrent.CountDownLatch;

/**
 *  CountDownLatch 测试类
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ "同学上完自习，回去睡觉了。。。");
                countDownLatch.countDown();
            }, i + "").start();
        }

        countDownLatch.await();

        System.out.println("班长锁门了");

    }

}
