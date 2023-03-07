package com.example.demo;

import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Test
    public void testUserService() {
        List<User> all = userService.findAll();
        log.info(all.toString());
    }

    @Test
    public void testStudentService() {
        Student student = new Student();
        student.setId("1");
        student.setAge(23);
        student.setName("李四");
        studentService.updateAndInsert(student);
    }

    @Test
    void contextLoads() {

    }


}
