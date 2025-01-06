package com.exercises.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Slf4j
public class Task3Test {
    //    public static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("\\.0*");
    public static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("^[GCDZTSPKXLY1-9]\\d{1,4}$");

    public static void main(String[] args) {

        String dateStr = new SimpleDateFormat("yyyy-MM").format(new Date());
        Date date = new Date();
        long time = date.getTime();
        String string = String.valueOf(time);
        System.out.println(string);

        String strVal = "11";
        System.out.println(strVal);
        Matcher matcher = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(strVal);
        if (matcher.find()) {
            System.out.println("\\.0*$");
        }
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
        log.error("dealProduceJoinOnlyDetailTable  sql=====:\n{}",joinTable);
        return joinTable.toString();
    }
}
