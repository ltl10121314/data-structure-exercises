package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        List<User> all = userService.findAll();
        log.info(all.toString());
    }

    @Test
    void contextLoads() {

    }


}
