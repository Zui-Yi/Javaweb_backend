package com.rx.mapper;

import com.rx.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //这是mybatis的user接口，在运行时，会自动生成该接口的实现类对象（动态代理对象），并且将该对象交给ioc容器管理
public interface UserMapper {

    //查询全部用户信息
    @Select("select * from user" )
    public List<User> list();


}
