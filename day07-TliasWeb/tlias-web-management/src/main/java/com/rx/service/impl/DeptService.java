package com.rx.service.impl;

import com.rx.mapper.DeptMapper;
import com.rx.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptService implements com.rx.service.DeptService {

    @Autowired //5、注入mapper对象，用于接受mapper数据
    private DeptMapper deptMapper;

    @Override //4、编写service中函数list，以用于调用mapper函数
    public List<Dept> list() {
        return deptMapper.list(); //8、接受mapper的list函数实现的sql语句
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);

    }

    @Override
    public void edit(Dept dept) {

        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.edit(dept);

    }

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }


}
