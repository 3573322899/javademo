package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

  /*  @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,@RequestParam  (defaultValue = "10") Integer pageSize){
    log.info("分页查询，当前页码：{}，每页记录数：{}",page,pageSize);
        return Result.success(empService.pageList(page, pageSize));
    }*/

    //条件分页查询
    @GetMapping
    public Result list (EmpQueryParam empQueryParam){
        log.info("条件分页查询：{}",empQueryParam);
        return Result.success(empService.pageList(empQueryParam));

    }

    //新增员工信息
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增员工信息：{}",emp);

        empService.add(emp);
        return Result.success();
    }
}
