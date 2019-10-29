package com.qf.j1906.service.impl;

import com.qf.j1906.mapper.DeptMapper;
import com.qf.j1906.pojo.Dept;
import com.qf.j1906.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: 刘旭
 * Date: 2019/10/29 10:43
 * @Version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        List<Dept> all = deptMapper.findAll();
        return all;
    }

    @Override
    public Dept selectById(int id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }

    @Override
    public Dept selectByName(String dname) {
        Dept dept = deptMapper.selectByName(dname);
        return dept;
    }

    @Override
    public void save(Dept dept) {
//        String id = UUID.randomUUID().toString();

      deptMapper.save(dept);

    }

    @Override
    public void modify(Dept dept) {
        deptMapper.modify(dept);
    }

    @Override
    public void deleteDeptById(int id) {
         deptMapper.deleteDeptById(id);

    }
}
