package com.lfj.springcloud.proxy;

/**
 *  代理接口实现类
 */
public class GunDog implements IDog {

    @Override
    public void run() {
        System.out.println("猎狗再跑！");
    }
}
