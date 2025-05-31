package com.springboot.mapper;

import com.springboot.domain.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> getAllEmps();

    Emp getEmpByEmpno(int empno);
}
