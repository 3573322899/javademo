package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService DeptService;

//    @RequestMapping(path = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list(){

        List<Dept> list=DeptService.findAll();
        log.info("查询所有部门数据：{}",list);
        return Result.success(list);
    }

    //删除部门
    @DeleteMapping
    public Result delete(Integer id){

//        System.out.println("删除的ID为"+id);
        log.info("删除的ID为：{}",id);
        DeptService.delete(id);
        return Result.success();
    }
    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("新增的部门数据为：" + dept);
        log.info("新增的部门数据为：{}",dept);
        DeptService.save(dept);
        return Result.success();
    }

    //根据id查询部门
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
//        System.out.println("查询的id为"+id);
        log.info("查询的id为：{}",id);
        Dept dept=DeptService.findById(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept){
//        System.out.println("修改的部门数据为："+dept);
        log.info("修改的部门数据为：{}",dept);
        DeptService.update(dept);
        return Result.success();
    }
}

