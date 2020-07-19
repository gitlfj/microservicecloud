package com.lfj.springcloud.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // 需要代理的对象
        IDog target = new GunDog();
        // 代理对象
        IDog proxy = (IDog) new GunDogProxy(target).gunDogProxyMethod();
        proxy.run();
    }

}
