package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {


    void addEmpExpr( List<EmpExpr> exprList);
}
