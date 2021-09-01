package com.datastructureexercises.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.Serializable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Liu Tianlong
 * @create: 2021-01-19 02:12
 **/
public class Hello implements Serializable {

    private static final long serialVersionUID = -3545112362061424843L;

    public static void main(String[] args) throws InterruptedException {
        List<String> arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        arrayList.add("test320210309");
        String str = "[{\"IS_FILE\":\"true\",\"FILE_MODIFY_TIME\":\"20210309 18:34:00\",\"FILE_PATH\":\"data/anhui/2021/03/test320210309001.dbf.gz.sms4\",\"FILE_NAME\":\"test320210309001.dbf.gz.sms4\",\"FILE_DIR_PATH\":\"data/anhui/2021/03/\"},{\"IS_FILE\":\"true\",\"FILE_MODIFY_TIME\":\"20210309 17:34:00\",\"FILE_PATH\":\"data/anhui/2021/03/test320210309002.dbf.gz.sms4\",\"FILE_NAME\":\"test320210309002.dbf.gz.sms4\",\"FILE_DIR_PATH\":\"data/anhui/2021/03/\"}]";
        JSONArray jsonArray = JSONArray.fromObject(str);
        for (String string : arrayList) {
            JSONArray jsonArray1 = new JSONArray();
            for (Object json : jsonArray) {
                JSONObject jsonObject = JSONObject.fromObject(json);
                String file_name = (String) jsonObject.get("FILE_NAME");
                file_name = file_name.substring(0, file_name.indexOf(".sms4"));
                file_name = file_name.substring(file_name.length() - 15, file_name.length() - 7);
                System.out.println(file_name);
                Matcher matcher = Pattern.compile(string + ".*").matcher(file_name);
                if (matcher.matches()) {
                    jsonArray1.add(string);
                }
            }

        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long timeInMillis = calendar.getTimeInMillis() + 24 * 60 * 60 * 1000;
        System.out.println(timeInMillis);
        long l = System.currentTimeMillis();
        System.out.println(l);
        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.add("test320210309001");
        jsonArray2.add("test320210309004");
        jsonArray2.add("test320210309003");
        jsonArray2.add("test320210309013");
        if (!jsonArray2.isEmpty()) {
            Collections.sort(jsonArray2);
            System.out.println(jsonArray2);
            String o = (String) jsonArray2.get(jsonArray2.size() - 1);
            System.out.println(o);
        }
    }

    @Test
    public void test1Test() {
        int i = 1;
        String j = String.valueOf(i);
        System.out.println(j);
        String k = "1";
        int r = Integer.parseInt(k);
        System.out.println(r);
        String t = "2";
        int e = Integer.parseInt(String.valueOf(t));
        System.out.println(e);
        JSONObject jsonObject = JSONObject.fromObject(null);
        System.out.println(jsonObject);
        System.out.println(Integer.MAX_VALUE);
        HashMap<Object, Object> heh = new HashMap<>();
        System.out.println(heh.toString());
    }

    @Test
    public void test2Test() {
        String str1 = "/data/nx/eas/table_name/2021/06/table_name.20210605.dbf.gz";
        String str2 = "/data/nx/eas/table_name1/2021/06/table_name1.20210605001.dbf.gz";
        String str3 = str1.substring(str1.lastIndexOf("/") + 1);
        System.out.println("str3：" + str3);
        String str4 = str1.substring(0, str1.lastIndexOf("/") + 1);
        System.out.println("str4：" + str4);
        String[] split = str3.split("\\.");
        System.out.println("split：" + split);
        String fileName = split[0];
        System.out.println("fileName：" + fileName);
        String dateString = split[1];
        System.out.println("dateString："+dateString);
        if (dateString.length()==8) {
            System.out.println("走："+str1);
        }else{
            System.out.println("走："+str2);
        }
    }

}
