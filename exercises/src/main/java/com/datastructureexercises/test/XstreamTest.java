package com.datastructureexercises.test;

import com.alibaba.fastjson.JSONObject;
import com.datastructureexercises.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class XstreamTest {
    public static void main(String[] args) {
        String s = "{\"name\": \"lisi\",\"code\": \"hehe\"}";
        JSONObject jsonObject = JSONObject.parseObject(s);

        BigDecimal bigDecimal = new BigDecimal("0");
        Map<Integer, User> map = new HashMap<>(8);
        ArrayList<Map<Integer, User>> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setName("zhangsan");
            user.setAddress("Beijing");
            user.setAge("12");
            map.put(i, user);
        }
        list.add(map);
        long start1 = System.currentTimeMillis();
        long end1 = System.currentTimeMillis();
        long start3 = System.currentTimeMillis();
        long end3 = System.currentTimeMillis();

        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        try {
            int i = 1 / 1;
            List<String> objects = new ArrayList<>();
        } catch (Exception e) {

        }
    }
}
