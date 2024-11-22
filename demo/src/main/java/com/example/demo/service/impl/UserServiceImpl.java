package com.example.demo.service.impl;

import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import com.example.demo.mapper.StudentDao;
import com.example.demo.mapper.UserDao;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 21:13
 * @description 用户逻辑层
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private StudentDao studentDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student insert(Student student) {
        studentDao.insert(student);
        return student;
    }

    @Override
    public List<User> findById(Map<String, Object> condition) {
        return userDao.findById(condition);
    }
}
