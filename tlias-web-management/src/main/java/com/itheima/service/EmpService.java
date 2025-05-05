package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface EmpService {
//    PageResult<Emp> pageList(Integer page, Integer pageSize);

    PageResult<Emp> pageList(EmpQueryParam empQueryParam);


    void add(Emp emp);
}
