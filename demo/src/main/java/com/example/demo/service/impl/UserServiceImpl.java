package com.example.demo.service.impl;

import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentDao;
import com.example.demo.mapper.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 21:13
 * @description 用户逻辑层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Student insert(Student student) {
        studentDao.insert(student);
        return student;
    }
}
