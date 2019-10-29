package com.qf.j1906.controller;

import com.qf.j1906.pojo.Dept;
import com.qf.j1906.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 刘旭
 * Date: 2019/10/29 14:55
 * @Version 1.0
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping(value="/depts",method = RequestMethod.GET)
    public ResponseEntity<List<Dept>> depts(){
        List<Dept> depts = deptService.findAll();
        ResponseEntity responseEntity = new ResponseEntity(depts, HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping(value="/dept/{id}",method = RequestMethod.GET)
    public ResponseEntity<Dept> queryDeptById(@PathVariable("id") int id){
        Dept dept=deptService.selectById(id);
        if(dept!=null){
            return new ResponseEntity<Dept>(dept,HttpStatus.OK);
        }else{
            return new ResponseEntity<Dept>(HttpStatus.NOT_FOUND);
        }
    }
    //部门信息添加
    @RequestMapping(value="/dept",method = RequestMethod.POST)
    public ResponseEntity<Dept> addDept(Dept dept){
        if(!StringUtils.isEmpty(dept.getDname())){
           Dept dept1= deptService.selectByName(dept.getDname());
           if(dept1==null){//对象不存在，可以写入数据库
               deptService.save(dept);
               return new ResponseEntity<Dept>(dept,HttpStatus.OK);
           }else {//对象冲突
               return new ResponseEntity<Dept>(HttpStatus.CONFLICT);
           }
        }else{//数据库不完整，请求无效
            return new ResponseEntity<Dept>(HttpStatus.BAD_REQUEST);
        }
    }
    //修改信息
    @RequestMapping(value="/dept/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Dept> Dept(@PathVariable("id") int id, Dept dept){
        if(id>0){
            Dept dept1= deptService.selectById(id);
            if(dept1!=null){//对象存在，可以修改
                dept1.setDname(dept.getDname());
                dept1.setLoc(dept.getLoc());
                deptService.modify(dept1);
                return new ResponseEntity<Dept>(dept,HttpStatus.OK);
            }else {//修改的对象不存在
                return new ResponseEntity<Dept>(HttpStatus.NO_CONTENT);
            }
        }else{//数据不完整，请求无效
            return new ResponseEntity<Dept>(HttpStatus.BAD_REQUEST);
        }
    }
    //删除数据
    @RequestMapping(value = "/dept/{id}",method=RequestMethod.DELETE)
    public ResponseEntity deleteDeptById(@PathVariable("id")int id){
        Dept dept1= deptService.selectById(id);
        if(dept1==null){//对象不存在，无需删除
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {//删除的对象存在
           deptService.deleteDeptById(id);
            return new ResponseEntity(HttpStatus.OK);//对象删除成功
        }
    }
}
