package com.datastructureexercises.test;

import com.datastructureexercises.domain.User;
import com.datastructureexercises.domain.UserDetail;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liutianlong
 */
@Slf4j
public class TaskTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTest.class);

    public static void main(String[] args) throws ParseException {
        // 日常环境
        String temp = "0000L0GCJTKI6JSSV00000-dataenc";
        System.out.println("hashCode=" + temp.hashCode());
        int hash = temp.hashCode();
        System.out.println(hash);
        String sss;
        if (hash < 0) {
            sss = (hash + "").replaceFirst("-", "");
            System.out.println("-sss=" + sss);
        } else {
            sss = hash + "";
            System.out.println("sss" + sss);
        }
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map_1 = new HashMap<>();
        map_1.put("code", "a");
        map_1.put("order", 3);
        Map<String, Object> map_2 = new HashMap<>();
        map_2.put("code", "b");
        map_2.put("order", 1);
        Map<String, Object> map_3 = new HashMap<>();
        map_3.put("code", "c");
        map_3.put("order", 2);
        list.add(map_1);
        list.add(map_2);
        list.add(map_3);
        List<Map<String, Object>> collect = list.stream().sorted(Comparator.comparing(m -> (Integer) m.get("order"))).collect(Collectors.toList());
        String code = list.stream().map(m -> m.get("code").toString()).collect(Collectors.joining(","));
        System.out.println(code);
        System.out.println(collect);

    }

    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
//        list.removeIf("a"::equals);
        List<String> list2 = new ArrayList<>();
        list2.addAll(list);
        list.clear();
        System.out.println(list);
        System.out.println(list2);
//        Map<String, List<String>> map = new HashMap<>();
//        map.put("e", list);
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//            List<String> value = entry.getValue();
//            value.clear();
//            value.add("ff");
//        }
//        System.out.println(map);
    }

    @Test
    public void test3() {
        BigDecimal decimal = new BigDecimal("20.8900");
        double a = Double.parseDouble(decimal.toString());
        List<Map<String, Object>> staffList = new ArrayList<>();
        Map<Object, Map<String, Object>> hah = staffList.stream().collect(Collectors.toMap(m -> m.get("hah"), m -> m, (v1, v2) -> v1));
        BigDecimal decimal_1 = new BigDecimal("1");
        BigDecimal decimal_2 = new BigDecimal("2");
        System.out.println(decimal_1.compareTo(decimal_2));
        System.out.println(decimal_2.compareTo(decimal_1));
        System.out.println(decimal_1.compareTo(decimal_1));
        List<Integer> index = new ArrayList<>();
        index.add(2);
        index.add(4);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");

        System.out.println("==========");
        for (int i = 0; i <= index.size(); i++) {
            List<String> strings;
            if (i == 0) {
                strings = list.subList(0, index.get(i) + 1);
            } else if (i == index.size()) {
                strings = list.subList(index.get(i - 1) + 1, list.size());
            } else {
                strings = list.subList(index.get(i - 1) + 1, index.get(i) + 1);
            }
            System.out.println(strings);
        }
    }

    public static String cleanXSS(String value) {
        if (StringUtils.isEmpty(value)) {
            return value;
        }
        //在这里自定义需要过滤的字符
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)", "");
        value = value.replaceAll("[\"'][s]*javascript:(.*)[\"']", "\"\"");
        value = value.replaceAll("<script>", "");
        return value;
    }

    public static boolean isDate(String date) {
        if (date == null) {
            return false;
        }
        try {
            DateUtils.parseDate(date, "yyyy-MM-dd");
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


}
