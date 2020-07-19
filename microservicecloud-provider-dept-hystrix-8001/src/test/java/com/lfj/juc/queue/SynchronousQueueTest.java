package com.lfj.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *  SynchronousQueue
 *  是一个内部只能包含一个元素的队列。插入元素到队列的线程被阻塞，
 *  直到另一个线程从队列中获取了队列中存储的元素。同样，
 *  如果线程尝试获取元素并且当前不存在任何元素，则该线程将被阻塞，直到线程将元素插入队列
 */
public class SynchronousQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque =  new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ", put");
                blockingDeque.put("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(Thread.currentThread().getName() + ", put");
                blockingDeque.put("b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(Thread.currentThread().getName() + ", put");
                blockingDeque.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();


        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("blockingDeque.take() = " + blockingDeque.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("blockingDeque.take() = " + blockingDeque.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("blockingDeque.take() = " + blockingDeque.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }

}
