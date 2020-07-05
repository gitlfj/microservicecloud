package com.lfj.springcloud.service.impl;

import com.lfj.springcloud.entities.Dept;
import com.lfj.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class DeptServiceImpl implements DeptService {

    public static Map<Long, Dept> initMap = new HashMap<>();

//    @Autowired
//    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
//        return deptDao.addDept(dept);
        initMap.put(4L, dept);
        return true;
    }

    @Override
    public Dept get(Long id) {
        return initMap.get(id);
    }

    @Override
    public List<Dept> list() {
        List<Dept> list = new ArrayList<>();
        Set<Long> longs = initMap.keySet();
        for (Long aLong : longs) {
            Dept dept = initMap.get(aLong);
            list.add(dept);
        }
        return list;
    }


    @PostConstruct
    private void init() {
        System.out.println("初始化方法。。。。");
        initMap.put(1L, new Dept(1L, "研发部", "一号数据库"));
        initMap.put(2L, new Dept(2L, "人事部", "一号数据库"));
        initMap.put(3L, new Dept(3L, "财务部", "一号数据库"));

    }

}
