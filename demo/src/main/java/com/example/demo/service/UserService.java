package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

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
}
