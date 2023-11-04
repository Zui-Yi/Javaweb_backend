package com.rx.mapper;

import com.rx.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {


/*    @Select("select count(*) from emp")
    public Long count();

    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start,Integer pageSize);*/




/*    @Select("select * from emp where name like concat('%',#{},'%') and" +
            " gender=#{} and entrydate between #{} and #{} order by  update_time desc")*/
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    public void delete(List<Integer> ids);

    void add(Emp emp);
}
