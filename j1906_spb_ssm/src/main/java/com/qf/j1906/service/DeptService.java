package com.qf.j1906.service;

import com.qf.j1906.pojo.Dept;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/29 10:41
 * @Version 1.0
 */

public interface DeptService {
    public List<Dept> findAll();

    public Dept selectById(int id);

    public Dept selectByName(String dname);

    public void save(Dept dept);

    public void modify(Dept dept);

    public void deleteDeptById(int id);
}
