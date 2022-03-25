package com.datastructureexercises.test;

import com.alibaba.fastjson.JSONObject;
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
        log.info(jsonObject.getString("name"));

        BigDecimal bigDecimal = new BigDecimal("0");
        log.info(String.valueOf(bigDecimal));
        Map<String, String> map = new HashMap<>();
        log.info("-----------");
        String hehe = map.get(null);
        log.info("------------");
        log.info(hehe);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        log.info(format);
        try {
            int i = 1 / 1;
            List<String> objects = new ArrayList<>();
        } catch (Exception e) {
            log.error("Load xml error : ", e);

        }
    }
}
