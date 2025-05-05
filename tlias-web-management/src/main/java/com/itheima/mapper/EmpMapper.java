package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {

/*
    @Select("select count(*) from emp e left join  dept d on e.dept_id=d.id;")
    public long count();

    @Select("select e.* , d.name deptName from emp e left join  dept d on e.dept_id=d.id " +
            "order by e.update_time desc limit #{start} , #{pageSize}")
    public List<Emp> list(@Param("start") Integer start,@Param("pageSize") Integer pageSize);*/

    //基于pagehelper  的分页查询实现
  /*  @Select("select e.* , d.name deptName from emp e left join  dept d on e.dept_id=d.id " +
            "order by e.update_time desc ")
    public List<Emp> list();*/


    //条件查询
   List<Emp> list(EmpQueryParam empQueryParam);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO emp (username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)\n" +
            "VALUES (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);
}
