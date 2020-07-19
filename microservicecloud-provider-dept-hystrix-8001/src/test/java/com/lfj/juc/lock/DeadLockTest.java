package com.lfj.juc.lock;

/**
 *  手写死锁
 */
public class DeadLockTest {

    public static void main(String[] args) {

        String lockA = "AAA";
        String lockB = "BBB";

        new Thread(new DeadLockDome(lockA, lockB)).start();
        new Thread(new DeadLockDome(lockB, lockA)).start();

    }

}

class DeadLockDome implements Runnable {

    private String lockA;

    private String lockB;

    public DeadLockDome(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("自己获得A锁尝试获取B锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println("自己获得B锁尝试获取A锁");
            }
        }
    }


    public static void main(String[] args) {
        while (true) {

        }
    }
}
