package com.lfj.springcloud.controller;

import com.lfj.HelloService;
import com.lfj.springcloud.entities.Dept;
import com.lfj.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  Controller
 */
@RestController
public class DeptController {


    @Autowired
    private DeptService service;


    @Autowired
    private HelloService helloService;


    /**
     *  根据id查询,服务熔断
     * @param id
     * @return
     */
    @RequestMapping(value="/dept/get/{id}",method= RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallMethod")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id);
        if (dept == null) {
            throw new RuntimeException("当前ID查询不到数据");
        }
        return dept;
    }

    /**
     *  指定服务熔断方法
     * @param id
     * @return
     */
    private Dept fallMethod(@PathVariable("id") Long id) {
        return new Dept(id, "获取不到数据", "一号库");
    }


    /**
     *  自定义starter
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return helloService.sayHello("springboot");
    }

}
