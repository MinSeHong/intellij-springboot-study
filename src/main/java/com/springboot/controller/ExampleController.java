package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class ExampleController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 📘 단건 조회: GET /emp/{empno}
    @GetMapping("/{empno}")
    public Map<String, Object> getOne(@PathVariable int empno) {
        return jdbcTemplate.queryForMap("SELECT * FROM emp WHERE empno = ?", empno);
    }

    // 📘 추가: POST /emp
    @PostMapping
    public String insert(@RequestParam int empno, @RequestParam String ename, @RequestParam String job) {
        int rows = jdbcTemplate.update("INSERT INTO emp (empno, ename, job) VALUES (?, ?, ?)", empno, ename, job);
        return rows > 0 ? "등록 성공" : "등록 실패";
    }

    // 📘 수정: PUT /emp/{empno}
    @PutMapping("/{empno}")
    public String update(@PathVariable int empno, @RequestParam String job) {
        int rows = jdbcTemplate.update("UPDATE emp SET job = ? WHERE empno = ?", job, empno);
        return rows > 0 ? "수정 성공" : "수정 실패";
    }

    // 📘 삭제: DELETE /emp/{empno}
    @DeleteMapping("/{empno}")
    public String delete(@PathVariable int empno) {
        int rows = jdbcTemplate.update("DELETE FROM emp WHERE empno = ?", empno);
        return rows > 0 ? "삭제 성공" : "삭제 실패";
    }
}