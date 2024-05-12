package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

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
        map1.put("id", "1");
        map1.put("age", 11);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("age", 11);
        list.add(map1);
        list.add(map2);
        studentDao.batchUpdate("student", list);
    }

    @Test
    public void testStudentService2() {
        String id = UUID.randomUUID().toString().replace("-","");
        Student student = new Student();
        student.setId(id);
        student.setAge(23);
        student.setName("李四");
        int insert = studentDao.insert(student);
        log.info("插入人数:{}", insert);
        List<Student> students = studentDao.queryAllByLimit(0, 10);
        log.info("查询数据:{}", students);
        Integer delete = studentDao.deleteById(id);
        log.info("删除人数:{}", delete);
    }

    @Test
    public void insertData(){
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(String.valueOf(i));
            // 创建Random类的实例
            Random random = new Random();
            // 生成一个从0（包括）到10（不包括）的随机整数
            int age = random.nextInt(30);
            student.setAge(age);
            student.setName("张三"+i);
            int insert = studentDao.insert(student);
            log.info(String.valueOf(insert));
        }
    }
}
