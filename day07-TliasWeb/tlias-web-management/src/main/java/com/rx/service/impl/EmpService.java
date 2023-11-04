package com.rx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rx.mapper.EmpMapper;
import com.rx.pojo.Emp;
import com.rx.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpService implements com.rx.service.EmpService {

    @Autowired
    private EmpMapper empMapper;

    /*@Override
    public PageBean page(Integer page, Integer pageSize) {

        //1、调用mapper接口获取总记录数total
        long count = empMapper.count();
        //2、调用mapper接口获取数据列表rows
        int start=(page-1)*pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);
        //3、封装成PageBean对象
        PageBean pageBean=new PageBean(count,empList);

        return pageBean;
    }*/

    @Override
    public PageBean page(Integer page, Integer pageSize,
                         String name, Short gender,
                         LocalDate begin, LocalDate end) {
        //1、设置分页参数
        PageHelper.startPage(page,pageSize);

        //2、执行查询
        List<Emp> empList=empMapper.list(name, gender, begin, end);
        Page<Emp> p=(Page<Emp>) empList;

        //3、封装成PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

}
