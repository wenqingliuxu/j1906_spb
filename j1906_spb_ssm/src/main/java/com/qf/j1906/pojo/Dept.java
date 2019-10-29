package com.qf.j1906.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: 刘旭
 * Date: 2019/10/29 10:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {
    private int deptno;
    private String dname;
    private String loc;
}
