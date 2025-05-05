package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

/*    @Override
    public PageResult<Emp> pageList(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        List<Emp> list = empMapper.list(start, pageSize);
        long count = empMapper.count();
        PageResult<Emp> empPageResult = new PageResult<Emp>(count, list);
        return empPageResult;
    }*/

    //基于PageHelper的分页查询实现
 /*   @Override
    public PageResult<Emp> pageList(Integer page, Integer pageSize) {
       PageHelper.startPage(page,pageSize);

        List<Emp> list = empMapper.list();

        Page<Emp> empPage =(Page<Emp>)list;
        PageResult<Emp> empPageResult = new PageResult<Emp>(empPage.getTotal(), empPage.getResult());
        return empPageResult;

        }*/

//分页查询
    @Override
    public PageResult<Emp> pageList(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());

        List<Emp> list = empMapper.list(empQueryParam);

        Page<Emp> empPage =(Page<Emp>)list;
        PageResult<Emp> empPageResult = new PageResult<Emp>(empPage.getTotal(), empPage.getResult());
        return empPageResult;

    }

  /*  @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
        emp.getEmpExprList().forEach(empExpr -> empExpr.setEmpId(emp.getId()));
        empExprMapper.addEmpExpr(emp.getEmpExprList());

    }*/
    /*事务注解*/
    //指定事务回滚的异常
    @Transactional(rollbackFor = {Exception.class})
  @Override
  public void add(Emp emp) {
      //1.补全基础属性
      emp.setCreateTime(LocalDateTime.now());
      emp.setUpdateTime(LocalDateTime.now());
      //2.保存员工基本信息
      empMapper.add(emp);
      /*   int aaa= 1/0;*/
      //3. 保存员工的工作经历信息 - 批量
      Integer empId = emp.getId();
      List<EmpExpr> exprList = emp.getExprList();
      if(!CollectionUtils.isEmpty(exprList)){
          exprList.forEach(empExpr -> empExpr.setEmpId(empId));
          empExprMapper.addEmpExpr(exprList);


      }
  }
}
