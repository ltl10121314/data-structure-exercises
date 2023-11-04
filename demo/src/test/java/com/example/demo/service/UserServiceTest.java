package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Liu Tianlong
 * @program data-structure-exercises
 * @create 2023-05-14 23:51
 * @description 用户测试
 */
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;

    @Test
    public void testUserService() {
        List<User> all = userService.findAll();
        log.info(all.toString());
        log.info("============");
        Map<String, Object> map = new HashMap<>();
        Map<String, String> mapTmp = new HashMap<>();
        mapTmp.put("1", "a");
        mapTmp.put("2", "b");
        map.put("ids", mapTmp.keySet());
        List<User> byId = userService.findById(map);
        log.info(byId.toString());
    }

    @Test
    public void testUserDao(){
        Map<String, Object> map = new HashMap<>();
        Map<String, String> mapTmp = new HashMap<>();
        mapTmp.put("0", "a");
        map.put("ids", mapTmp.keySet());
        User userById = userDao.findUserById(map);
        System.out.println(userById);

        List<String> list = new ArrayList<>();
        list.remove("haha");
        System.out.println(list);
    }

    @Test
    public void test2UserDao(){
        List<User> all = userDao.findAll();
        log.info(all.toString());

    }

}
