package com.example.demo.service;

import com.example.demo.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-05-14 23:50
 * @description 学生测试
 */
public class StudentServiceTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void testStudentService() {
        Student student = new Student();
        student.setId("1");
        student.setAge(23);
        student.setName("李四");
        studentService.updateAndInsert(student);
    }
}
