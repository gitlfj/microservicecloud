package com.lfj.juc.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 *  自定义自旋锁
 */
public class CustomSpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();


    public void myLock() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("come in myLock... ThreadName = " + name);
        while (!atomicReference.compareAndSet(null, thread)) {
        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("unLock... ThreadName = " + name);
        atomicReference.compareAndSet(thread, null);
    }

}

class CustomSpinLockTest{
    public static void main(String[] args) {

        CustomSpinLock customSpinLock = new CustomSpinLock();


        new Thread(() -> {
            customSpinLock.myLock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customSpinLock.unLock();
        }, "t1").start();


        new Thread(() -> {
            customSpinLock.myLock();
            customSpinLock.unLock();
        }, "t2").start();


    }
}
