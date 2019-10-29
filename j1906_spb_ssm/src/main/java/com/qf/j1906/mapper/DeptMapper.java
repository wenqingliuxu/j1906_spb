package com.qf.j1906.mapper;

import com.qf.j1906.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/29 10:40
 * @Version 1.0
 */
@Mapper
@Repository
public interface DeptMapper {
    /**
     * 全查部门信息
     * @return Dept对象的集合
     */
    public List<Dept> findAll();
    public Dept selectById(int id);

    public Dept selectByName(String dname);

    public void save(Dept dept);

    public void modify(Dept dept);

    public void deleteDeptById(int id);
}
