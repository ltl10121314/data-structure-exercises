package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-05-14 23:50
 * @description 学生测试
 */
@SpringBootTest
@Slf4j
public class StudentServiceTest {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentDao studentDao;

    @Test
    public void testStudentService() {
        Student student = new Student();
        student.setId("1");
        student.setAge(23);
        student.setName("李四");
//        studentService.updateAndInsert(student);
//        studentService.queryById("1");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id","1");
        map1.put("age",11);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id","2");
        map2.put("age",11);
        list.add(map1);
        list.add(map2);
        studentDao.batchUpdate("student", list);
    }
}
