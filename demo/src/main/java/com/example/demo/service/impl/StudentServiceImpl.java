package com.example.demo.service.impl;

import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentDao;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 23:05
 * @description 学生逻辑实现层
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

//    @Autowired
//    private StudentService studentService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(String id) {
        return studentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return studentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student update(Student student) {
        studentDao.update(student);
        return queryById(student.getId());
    }

    private Student updateStudent(Student student) {
        studentDao.update(student);
        return queryById(student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return studentDao.deleteById(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAndInsert(Student student) {
        Student student1 = new Student();
        student1.setId("1");
        student1.setAge(77);
        student1.setName("第一邪皇");
        Student student2 = new Student();
        student2.setId("2");
        student2.setAge(88);
        student2.setName("第二刀皇");
        this.update(student1);
        this.updateStudent(student2);
        this.insert(student1);
    }

}
