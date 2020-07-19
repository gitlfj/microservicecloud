package com.lfj.juc.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  ArrayList线程不安全问题
 */
public class ArrayListTest {


    public static void main(String[] args) {
        // new一个线程安全的List实现类
        List<String> list2 = new Vector<>();
        // 使用Collections 工具类创建线程安全的List集合
        List<String> list1 = Collections.synchronizedList(new ArrayList<>());

        Set<String> set = new HashSet<>();
        set.add("欧阳傻逼");

        Map<String, String> map = new HashMap<>();
        map.put("", "");

        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0 ; i < 50; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,1));
                System.out.println(list);
            }).start();
        }

    }

}
