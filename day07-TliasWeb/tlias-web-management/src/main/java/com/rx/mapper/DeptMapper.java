package com.rx.mapper;

import com.rx.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from dept") //6、编写mapper中调用数据库的sql语句
    List<Dept> list();//7、将该sql语句结果放入Dept类型集合中，用于给service返回

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime}) ")
    void insert(Dept dept);

    @Update("update dept set name=#{name},update_time = #{updateTime} where id = #{id}")
    void edit(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);
}
