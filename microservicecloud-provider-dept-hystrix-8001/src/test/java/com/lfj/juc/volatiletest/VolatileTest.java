package com.lfj.juc.volatiletest;


import java.util.concurrent.atomic.AtomicInteger;

class MyData{

    /**
     *  主内存里面的值
     */
    volatile int value = 0;

    /**
     *  验证volatile的内存可见性
     */
    public void changValue() {
        this.value = 200;
    }

    /**
     *  验证volatile不保证原子性
     */
    public void add() {
        value ++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void atomicAdd() {
        atomicInteger.getAndIncrement();
    }

}

/**
 *  验证volatile
 *
 *  1.验证volatile的内存可见性
 *  2。验证volatile不保证原子性
 *
 */
public class VolatileTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MyData myData = new MyData();

        for (int i = 0; i< 20; i ++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.add();
                    myData.atomicAdd();
                }
            }, i + "_线程").start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        String name = Thread.currentThread().getName();

        System.out.println("ThreadName = " + name + ", value= " + myData.value + ", atomicValue= " + myData.atomicInteger.get());
        long endTime = System.currentTimeMillis();

        long l = endTime - startTime;
        System.out.println("l = " + l);

    }


    /**
     *  volatile 保证了内存可见性
     */
    public static void neicunsee() {
        MyData myData = new MyData();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("name = " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.changValue();
            System.out.println("myData Value = " + myData.value);
        }, "AAAA").start();


        while (myData.value == 0) {
        }

        System.out.println(Thread.currentThread().getName() + "**********-myData = " + myData.value);

    }


}

