package com.datastructureexercises.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liutianlong
 */
@Slf4j
public class TaskTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTest.class);

    public static void main(String[] args) {
        boolean a = true;
        double v1 = 0.1;
        double v2 = 0.2;
        double v3 = v1 + v2;
        System.out.println(v3);
        boolean notEmpty = StringUtils.isNotBlank(null + "");
        System.out.println(notEmpty);
        Object object1 = 123.0;
        Object value = null;
        // 格式化number String字符
        DecimalFormat df = new DecimalFormat("0");
        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        // 格式化数字
        DecimalFormat df2 = new DecimalFormat("0");
        Object object = 999;
        if (ObjectUtils.isEmpty(object)) {
            log.info("返回为空");
            return;
        }
        if (!isDate(String.valueOf(object))) {
            log.info("非日期格式");
            return;
        }
        if(!DateUtil.isDate(String.valueOf(object))){
            log.info("非日期格式2");
            return;
        }

        if ((DateUtil.StringToDate(String.valueOf(object), DateStyle.YYYY_MM_DD) == null)) {
            log.info("日期范围必须在{1753 年 1 月 1 日到 9999 年 12 月 31 日}之间");
            return;
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
