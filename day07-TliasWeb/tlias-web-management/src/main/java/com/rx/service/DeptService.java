package com.rx.service;

import com.rx.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    void edit(Dept dept);

    Dept selectById(Integer id);
}
