package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-03-02 21:16
 * @description 用户逻辑层接口
 */
public interface UserService {

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 插入学生逻辑
     * @param student 学生
     * @return
     */
    Student insert(Student student);

    /**
     * 批量查询用户
     * @param condition
     * @return
     */
    List<User> findById(Map<String, Object> condition);
}
