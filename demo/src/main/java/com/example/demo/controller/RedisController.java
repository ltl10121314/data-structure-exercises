package com.example.demo.controller;

import com.example.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liutianlong
 */
@RestController
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "setAndGet", method = RequestMethod.GET)
    public String setAndGet(String k, String v) {
        redisUtils.set(k, v);
        return (String) redisUtils.get(k);
    }
}
