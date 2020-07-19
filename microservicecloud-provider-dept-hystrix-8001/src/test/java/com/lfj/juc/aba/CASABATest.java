package com.lfj.juc.aba;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *  ABA 问题：
 *  ABA问题就是，有两个线程，线程1，线程2；有一个主内存值A，
 *  线程1和线程2都会有一个自己的工作内存主线程的内存值拷贝A
 *  当线程1将内存值A改成B了，然后又将B改成A，这都是没有问题的，此时线程2的内存拷贝的值是A
 *  去修改也可以成功，这就是ABA问题，本来线程2修改是不能成功，主内存的值已经改了
 *
 *  ABA问题解决：
 *
 *  需要新增一个版本号，修改值的时候也修改版本号
 *
 */
public class CASABATest {

    static AtomicInteger atomicInteger = new AtomicInteger(100);

    // 解决ABA问题，加版本号
    static AtomicStampedReference<Integer> atomicStampedReference =
            new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("-------以下是ABA问题的产生-------");
        new Thread(() -> {
            System.out.println(atomicInteger.compareAndSet(100, 2019));
            System.out.println(atomicInteger.compareAndSet(2019, 100));
        }, "t1").start();

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("atomicInteger.compareAndSet(100, 2020) = " + atomicInteger.compareAndSet(100, 2020));
        }, "t2").start();

        Thread.sleep(2000);

        System.out.println("-------以下是ABA问题的解决方案——》增加版本号-------");

        new Thread(() -> {
            System.out.println("atomicStampedReference.compareAndSet(100, 101, 1, 2) = " + atomicStampedReference.compareAndSet(100, 101, 1, 2));
            System.out.println("atomicStampedReference.compareAndSet(101, 100, 2, 3) = " + atomicStampedReference.compareAndSet(101, 100, 2, 3));
        }, "t3").start();

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("atomicStampedReference.compareAndSet(100, 2019, 1, 2) = " + atomicStampedReference.compareAndSet(100, 2019, 1, 2));

        }, "t4").start();


    }

}
