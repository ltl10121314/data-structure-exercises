package com.exercises.dao;

import com.exercises.domain.User;

import java.util.List;

/**
 * @author liutianlong
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return 返回用户实体
     */
    List<User> findAll();
}
