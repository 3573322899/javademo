package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT id, name, create_time, update_time\n" +
            "FROM dept\n" +
            "ORDER BY update_time DESC")
    public List<Dept> findAll();


    @Delete("DELETE FROM dept\n" +
            "WHERE id = #{id};")
    void delete(Integer id);

    @Insert("INSERT INTO dept (name,create_time,update_time)\n" +
            "VALUES (#{name},#{createTime},#{updateTime});" )
    void select(Dept dept);

    @Select("SELECT id, name, create_time, update_time \n" +
            "FROM dept \n" +
            "WHERE id = #{id}" )
    Dept findById(Integer id);

    @Update("UPDATE dept\n" +
            "SET name = #{name}, update_time = #{updateTime}\n" +
            "WHERE id = #{id};")
    void update(Dept dept);
}
