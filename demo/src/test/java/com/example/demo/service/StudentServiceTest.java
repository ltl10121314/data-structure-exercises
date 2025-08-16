package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import com.example.demo.log.MyLog;
import com.example.demo.mapper.StudentDao;
import com.example.demo.model.StudentParamVO;
import com.example.demo.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author liutianlong
 */
@SpringBootTest
@Slf4j
public class StudentServiceTest {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentDao studentDao;

    @Value("${databaseSchema:mysql}")
    private String databaseSchema;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test6(){
        studentService.task();
    }

    @Test
    public void test5(){
        String action = Thread.currentThread().getStackTrace()[2].getMethodName();
        Map<String, String> map = new HashMap<>();
        List<User> users = new ArrayList<>();
        Map<String, String> authName = users.stream().collect(Collectors.toMap(User::getId, User::getName, (v1, v2) -> v1));
        Set<String> schemeIds = new HashSet<>(authName.values());
        System.out.println(CollectionUtils.isEmpty(schemeIds));
        Student student = new Student();
    }

    @Test
    public void test4() {
        /*
        StudentParamVO param = new StudentParamVO();
        List<Student> allStudent = studentDao.findAll();
        log.error("allStudent:{}", allStudent);
        List<String> ids = allStudent.stream().map(Student::getId).collect(Collectors.toList());
        param.setIds(ids);
        log.error("入参:{}", param);

        redisUtils.set("param", param);
        StudentParamVO value1 = redisUtils.getValue("param");
        log.error("logInfo:{}", value1);

        List<Student> studentList = studentDao.queryStudentByCondition(param);
        log.error(studentList.toString());

        redisUtils.set("param", "哈哈");
        String value2 = redisUtils.getValue("param");
        log.error("logInfo:{}", value2);
         */
    }

    @Test
    public void test3() {
        Student student = new Student();
        student.setId("1");
        student.setAge(23);
        student.setName("李四");
        int update = studentDao.update(student);
        log.error("更新个数:{}", update);
    }

    @Test
    public void test2() {
        /*
        Student student = new Student();
        student.setId("1");
        student.setAge(23);
        student.setName("李四");
        studentService.updateAndInsert(student);
        Student student1 = studentService.queryById("1");
        log.info(student1.toString());
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "11");
        map1.put("age", 11);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "12");
        map2.put("age", 11);
        list.add(map1);
        list.add(map2);
        studentDao.batchUpdate("student", list);
         */
    }

    @Test
    public void test1() {
        String id = UUID.randomUUID().toString().replace("-", "");
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
    public void insertData() {
        for (int i = 0; i < 10; i++) {
            Integer delete = studentDao.deleteById(String.valueOf(i));
            log.error("delete size:{}", delete);
            Student student = new Student();
            student.setId(String.valueOf(i));
            // 创建Random类的实例
            Random random = new Random();
            // 生成一个从0（包括）到10（不包括）的随机整数
            int age = random.nextInt(30);
            student.setAge(age);
            student.setName("张三" + i);
            int insert = studentDao.insert(student);
            log.error("insert size:{}", insert);
        }
    }

    @Test
    public void queryDataByThread() {
        List<CompletableFuture> cfList = new ArrayList<>();
        Vector<Student> students = new Vector<>();
        for (int i = 0; i < 10; i++) {
//            String finalI = String.valueOf(i);
            CompletableFuture cf = CompletableFuture.runAsync(() -> {
//                Student student = studentDao.queryById(finalI);
                List<Student> studentList = studentDao.queryAllByLimit(0, 10);
//                students.add(student);
                students.addAll(studentList);
            });
            cfList.add(cf);
        }
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[0])).join();
        for (Student student : students) {
            log.info(student.toString());
        }
    }

    @Test
    public void task(){
        log.error("------------");
    }
}
