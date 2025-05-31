package com.springboot.domain;

import lombok.Data;

@Data
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private String hiredate;
    private int sal;
    private int deptno;
}
