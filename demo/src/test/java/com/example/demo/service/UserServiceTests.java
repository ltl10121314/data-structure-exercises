package com.example.demo.service;

import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-05-14 23:51
 * @description 用户测试
 */
@SpringBootTest
@Slf4j
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        List<User> all = userService.findAll();
        log.info(all.toString());
    }
}
