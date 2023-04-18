package com.example.demo;

import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import com.example.demo.domain.WaPayfileDoc;
import com.example.demo.mapper.WaPayfileDocDao;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private WaPayfileDocDao waPayfileDocDao;

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
        String tenantId = "0000KWA1Q2DF1521B50000";
        String waPayFileId = "1658532107197087750";
        List<WaPayfileDoc> waPayfileDocs = waPayfileDocDao.queryPayfileDocs(tenantId, waPayFileId);
        List<String> staffIds = waPayfileDocs.stream().map(WaPayfileDoc::getStaffId).collect(Collectors.toList());
        log.info("查询员工：{}", staffIds);
    }

    @Test
    void testWaUser() {

    }

}
