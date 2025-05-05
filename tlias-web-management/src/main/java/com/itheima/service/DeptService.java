package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void delete(Integer id);

    void save(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
