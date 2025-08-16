package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import com.example.demo.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 23:10
 * @description 学生控制层
 */
@RestController
@RequestMapping("student")
@Slf4j
public class StudentController {
    /**
     * 服务对象
     */
    @Autowired
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(@Param("id") String id) {
        log.info("hello");
        SpringContextUtil.getBean(UserService.class).findAll();
        return SpringContextUtil.getBean(StudentService.class).queryById(id);
    }

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("task")
    public void task() {
        studentService.task();
    }

    @PostMapping(value = {"/open-api/bankOffer/insertTemplateForIReport", "/internal/open-api/bankOffer/insertTemplateForIReport"})
    public void insertTemplateForIReport(HttpServletResponse response, @RequestBody Map<String, Object> param) {
        Object waBankOfferTemplate = param.get("wa_bank_offer_template");
        if (waBankOfferTemplate instanceof List) {
            List<Map<String, Object>> mapList = (List<Map<String, Object>>) waBankOfferTemplate;
            System.out.println("----------------");
        }
        System.out.println("0000000000000");
    }
}