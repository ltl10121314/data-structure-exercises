package com.exercises.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
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
        log.error(string);
        String strVal = "waitem.f_n_1+busi[waitem.f_n_2]";
        log.error(strVal);
        Matcher matcher = pattern.matcher(strVal);
        Set<String> set = new HashSet<>();
        while (matcher.find()) {
            String group = matcher.group();
            set.add(group);
        }
        log.error(set.toString());
    }

    @Test
    public void test2() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("1");
        linkedList.addFirst("2");
        linkedList.addFirst("3");
        log.error(linkedList.toString());
        String pop = linkedList.pop();
        log.error(pop);
        linkedList.push("4");
        log.error(linkedList.toString());
        String peek = linkedList.peek();
        log.error(peek);
        log.error(linkedList.toString());

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
        log.error(tableNames.toString());
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
