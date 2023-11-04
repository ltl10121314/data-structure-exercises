package com.datastructureexercises.test;

import com.alibaba.fastjson.JSONObject;
import com.datastructureexercises.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liutianlong
 */
@Slf4j
public class TaskTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTest.class);

    public static void main(String[] args) {
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
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        String join = StringUtils.join(set, ",").toUpperCase();
        System.out.println(join);

        boolean b = new BigDecimal("0.0000000").compareTo(BigDecimal.ZERO) == 0;
        System.out.println(b);
        List<User> list = new ArrayList<>();
        Map<String, String> stringMap = list.stream().collect(Collectors.toMap(User::getId, User::getCode));
        String hah = stringMap.get("hah");
        System.out.println(hah);
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
