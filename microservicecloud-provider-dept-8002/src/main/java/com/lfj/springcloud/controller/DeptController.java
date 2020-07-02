package com.lfj.springcloud.controller;

import com.lfj.HelloService;
import com.lfj.springcloud.entities.Dept;
import com.lfj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     *  新增
     * @param dept
     * @return
     */
    @RequestMapping(value="/dept/add",method=RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    /**
     *  根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value="/dept/get/{id}",method= RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    /**
     *  查询全部
     * @return
     */
    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
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
