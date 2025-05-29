package com.springboot.dbms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DbTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/dbmsConsole")
    public String testConnection() {
        try {
            String sql = "SELECT * FROM emp";
            List<Map<String, Object>> empList = jdbcTemplate.queryForList(sql);

            for (Map<String, Object> row : empList) {
                System.out.println(row);
                // 혹은 원하는 컬럼만 출력
                // System.out.println("EMPNO: " + row.get("EMPNO") + ", ENAME: " + row.get("ENAME") + ", JOB: " + row.get("JOB"));
            }
            System.out.println("전체 emp 데이터 조회 완료");
        } catch (Exception e) {
            System.out.println("조회 실패: " + e.getMessage());
        }
        return "콘솔에 emp 전체 출력 완료";
    }

    @GetMapping("/dbmsJson")
    public List<Map<String, Object>> selectAllEmp() {
        String sql = "SELECT * FROM emp";
        List<Map<String, Object>> empList = jdbcTemplate.queryForList(sql);
        return empList;
    }
}