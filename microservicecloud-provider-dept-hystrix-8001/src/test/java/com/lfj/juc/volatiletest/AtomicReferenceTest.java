package com.lfj.juc.volatiletest;

import java.util.concurrent.atomic.AtomicReference;

/**
 *  原子引用测试类
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {

        AtomicReference<User> atomicReference = new AtomicReference<>();
        User user1 = new User("张三", 20);

        User user2 = new User("李四", 28);

        atomicReference.set(user1);

        System.out.println(atomicReference.compareAndSet(user1, user2) +  ", current data = " + atomicReference.get());

        System.out.println(atomicReference.compareAndSet(user1, user2) +  ", current data = " + atomicReference.get());


    }



}

class User{

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
