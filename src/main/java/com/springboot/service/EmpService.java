package com.springboot.service;

import com.springboot.domain.Emp;
import com.springboot.mapper.EmpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpService {

    private final EmpMapper empMapper;

    public List<Emp> getAllEmps() {
        return empMapper.getAllEmps();
    }

    public Emp getEmpByEmpno(int empno) {
        return empMapper.getEmpByEmpno(empno);
    }
}