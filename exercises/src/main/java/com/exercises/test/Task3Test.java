package com.exercises.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Task3Test {
    //    public static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("\\.0*");
    public static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("^[GCDZTSPKXLY1-9]\\d{1,4}$");
    public static final Pattern pattern = Pattern.compile("waitem.f_[i,v,d,b,n]_\\d+");
    public static void main(String[] args) {
        String dateStr = new SimpleDateFormat("yyyy-MM").format(new Date());
        Date date = new Date();
        long time = date.getTime();
        String string = String.valueOf(time);
        System.out.println(string);
        String strVal = "waitem.f_n_1+busi[waitem.f_n_2]";
        System.out.println(strVal);
        Matcher matcher = pattern.matcher(strVal);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
        String value = null+"";
        System.out.println(value);
    }

    @Test
    public void test2() {
        BigDecimal zero = new BigDecimal("0.0000");
        BigDecimal zero2 = new BigDecimal("0");
        int i = zero.compareTo(zero2);
        log.error(String.valueOf(i));
        boolean b = (new BigDecimal("0.0")).compareTo(BigDecimal.ZERO) == 0;
        System.out.println(b);
        Integer[] a = new Integer[5];
        for (Integer i1 : a) {
            System.out.println(i1);
        }
    }

    @Test
    public void test1() {
        Set<String> tableNames = new HashSet<>();
        tableNames.add("tableName1");
        tableNames.add("tableName");
        tableNames.add("tableName2");
        tableNames.add("tableName3");
        String tableName = "tableName";
        tableNames.remove(tableName);
        System.out.println(tableNames);
        dealProduceJoinTableByTableNames(tableNames, "tableName", "wpd");
    }

    public static String dealProduceJoinTableByTableNames(Set<String> tableNames, String mulDbTableName, String aliasDetail) {
        StringBuffer joinTable = new StringBuffer();
        joinTable.append(mulDbTableName).append(" ").append(aliasDetail);
        int tableNum = 1;
        if (CollectionUtils.isEmpty(tableNames)) {
            tableNames.add(mulDbTableName);
        }
        for (String tableName : tableNames) {
            String aliasOther = aliasDetail + tableNum;
            joinTable.append(" LEFT JOIN").append(" ").append(tableName).append(" ").append(aliasOther).append(" ON ")
                    .append(aliasDetail).append(".").append("PK_PAYFILE = ").append(aliasOther).append(".").append("PK_PAYFILE").append(" AND ")
                    .append(aliasDetail).append(".").append("PK_PAYFILE_DOC = ").append(aliasOther).append(".").append("PK_PAYFILE_DOC").append(" AND ")
                    .append(aliasDetail).append(".").append("ytenant_id = ").append(aliasOther).append(".").append("ytenant_id");
            tableNum++;
        }
        log.error("dealProduceJoinOnlyDetailTable  sql=====:\n{}", joinTable);
        return joinTable.toString();
    }
}
