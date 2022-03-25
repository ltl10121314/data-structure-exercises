package com.datastructureexercises.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liutianlong
 */
public class TaskTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTest.class);

    public static void main(String[] args) {
        Integer integer = null;
        System.out.println(integer);
        HashMap<String, String> map22 = new HashMap<>();
        map22.put("psnclname", "");
        String psnlName = map22.get("psnclname") != null ? map22.get("psnclname").toString() : null;
        User user1 = new User();
        user1.setName("zhangsan");
        user1.setAddr("北京");
        user1.setAge("12");
        User user2 = new User();
        user2.setName("lisi");
        user2.setAddr("天津");
        user2.setAge("13");
        Map<String, Object> result = new HashMap<>();

        List<User> itemVOS = new ArrayList<>();
        itemVOS.add(user1);
        itemVOS.add(user2);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> p1 = new HashMap<>();
        p1.put("zhangsan", new BigDecimal(12));
        Map<String, Object> p2 = new HashMap<>();
        p2.put("lisi", new BigDecimal(23));
        list.add(p1);
        list.add(p2);
        //所有项目
        List<String> itemCodes = itemVOS.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(itemCodes.toString());
        System.out.println(list.toString());
        result = itemCodes.stream()
                .filter(key -> key != null)
                .collect(
                        Collectors.toMap(
                                key -> key,
                                key -> list.stream()
                                        .filter(map -> map.get(key) != null)
                                        .mapToDouble(
                                                map -> Double.valueOf(map.get(key).toString())
                                        ).sum()
                        )
                );
//        result = itemCodes.stream()
//                .filter(key -> key != null)
//                .collect
        System.out.println(result.toString());


    }

}
