package com.lfj.springcloud.service;

import com.lfj.springcloud.entities.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {

     boolean add(Dept dept);
     Dept    get(Long id);
     List<Dept> list();


}
