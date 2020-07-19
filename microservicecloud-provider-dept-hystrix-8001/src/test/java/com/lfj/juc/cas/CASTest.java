package com.lfj.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2091) + "\t current Data = " + atomicInteger.get());

        System.out.println("atomicInteger.compareAndSet(5, 2010) = " + atomicInteger.compareAndSet(5, 2010) + "\t current Data = " + atomicInteger.get());
    }

}
