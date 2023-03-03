package com.datastructureexercises.service;

import com.datastructureexercises.domain.User;

import java.util.List;

/**
 * @author liutianlong
 */
public interface UserService {
    /**
     * 查询所有用户
     * @return 返回用户实体
     */
    List<User> findAll();
}
