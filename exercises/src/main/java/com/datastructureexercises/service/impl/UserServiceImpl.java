package com.datastructureexercises.service.impl;

import com.datastructureexercises.domain.User;
import com.datastructureexercises.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author liutianlong
 */
@Service
public class UserServiceImpl implements UserService {


    /**
     * 查询所有用户
     *
     * @return 返回用户实体
     */
    @Override
    public List<User> findAll() {
        return null;
    }
}
