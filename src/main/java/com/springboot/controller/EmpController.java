package com.springboot.controller;

import com.springboot.domain.Emp;
import com.springboot.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/mybatis")
@RequiredArgsConstructor
public class EmpController {
    private final EmpService empService;

    @GetMapping
    public List<Emp> getAll() {
        return empService.getAllEmps();
    }

    @GetMapping("/{empno}")
    public Emp getOne(@PathVariable int empno) {
        return empService.getEmpByEmpno(empno);
    }
}
