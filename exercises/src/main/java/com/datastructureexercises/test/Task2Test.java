package com.datastructureexercises.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.compile;

/**
 * @author liutianlong
 */
@Slf4j
public class Task2Test {

    public static ThreadLocal<String> isExistDynamicAuthToken = new ThreadLocal<>();


    public static void main(String[] args) {

    }

    public static boolean isNeedParser(String formulastr) {
        Pattern numberPattern = compile("[0-9]*");
        boolean isneed = false;
        if (StringUtils.isEmpty(formulastr)) {
            return false;
        } else {
            formulastr = formulastr.replaceAll("\\.", "");
            isneed = !numberPattern.matcher(formulastr).matches();
            return isneed;
        }
    }

    private static String encrypt3ToMD5(String password){
        String md5 = "";
        md5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        return md5;
    }

    @Test
    public void test1() {
        Object date = new Date();
        String st = "F_N_20";
        String substring = st.substring(0, 4);
        log.info(substring);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        log.info("{}", format);

    }

    @Test
    public void test2() {
        String str = "F_N_10";
        String [] arr = str.split("_");
        if (arr.length>1){
            StringBuilder sb = new StringBuilder(arr[0]);
            for (int i=1; i<arr.length; i++){
                sb.append(arr[i].substring(0,1).toUpperCase());
                if (arr[i].length()>1){
                    sb.append(arr[i].substring(1));
                }
            }
            System.out.println(sb.toString());
        }
        String s = "";
        List<String> strings = Collections.singletonList(s);
        System.out.println(strings);
        List<String> orgPowerIds = Arrays.asList(s.split(","));
        System.out.println(orgPowerIds);
        Map<String, String> map = new HashMap<>();
        String hehe = map.get("hehe");
        System.out.println(hehe);
    }

    @Test
    public void test3() {
        String s = "人力成本开发部牛逼屌炸天";
        String json = "{\n" +
                "  \"a\": \"12\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        String password = jsonObject.getOrDefault("password", "").toString();
        log.info(password.getClass().toString());
        String md5 = encrypt3ToMD5(s);
        log.info(md5);
        String string = JSON.toJSONString(null);
        System.out.println(string);
        List<User> list = new ArrayList<>();
        List<User> list2 = new ArrayList<>();
        list.add(new User("a", "2", "京"));
        list.add(new User("a", "3", "沪"));
        list.add(new User("a", "4", "辽"));
        list.add(new User("b", "5", "黑"));
        list.add(new User("b", "6", "蒙"));
        list.add(new User("b", "7", "陕"));
        list2.add(new User("b", "7", "陕"));
        list.removeAll(list2);
        System.out.println(list);
        Map<String, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(collect);
    }

    @Test
    public void test4() {
        String id = "{\n" +
                "  \"scopes\": []\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(id);
        String scopes = jsonObject.getString("scopes");
        JSONArray jsonArray = JSONArray.fromObject(scopes);
        System.out.println(jsonArray.isEmpty());

        List<String> ids = new ArrayList<>();
        ids.add("12");
        Set<String> set = new HashSet<>();
        List<String> allIds = new ArrayList<>(set);
        ids.removeAll(allIds);
        System.out.println(ids);
    }


    @Test
    public void test5() {
        List<Category> list = creatList();
        List<Category> itemCategoryList = dealCategoryNode(list);
        List<String> categoryIdList = new ArrayList<>();
        categoryIdList.add("112");
        categoryIdList.add("212");
        Iterator<Category> iterator = itemCategoryList.iterator();
        while (iterator.hasNext()){
            Category next = iterator.next();
            traversalCategory(next, categoryIdList, iterator);
        }
        log.info(itemCategoryList.toString());
    }

    @Test
    public void test6(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("B");
        list2.add("B");
        list1.removeAll(list2);
        System.out.println(list1);
    }

    private void traversalCategory(Category next, List<String> categoryIdList, Iterator<Category> iterator){
        if(next.getChildren() == null){
            boolean contains = categoryIdList.contains(next.getId());
            if(!contains){
                iterator.next().setChildren(null);
                return;
            }
        }
        Iterator<Category> iteratorSub = next.getChildren().iterator();
        while (iteratorSub.hasNext()){
            Category nextSub = iterator.next();
            traversalCategory(nextSub, categoryIdList, iteratorSub);
        }
    }

    private List<Category> dealCategoryNode(List<Category> categoryList) {
        Map<String, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getId, Function.identity()));
        for (Category category : categoryList) {
            Category parentCategory = categoryMap.get(category.getParentid()) == null ? null : categoryMap.get(category.getParentid());
            if (parentCategory == null) {
                continue;
            }
            List<Category> children = parentCategory.getChildren();
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(category);
            parentCategory.setChildren(children);
        }
        categoryList = new ArrayList<>();
        for (String k : categoryMap.keySet()) {
            Category category = categoryMap.get(k);
        }
        return categoryList;
    }

    private List<Category> creatList() {
        List<Category> list = new ArrayList<>();
        Category category1 = new Category("1", "目录1", null, null);
        Category category2 = new Category("2", "目录2", null, null);
        Category category3 = new Category("3", "目录3", null, null);
        Category category4 = new Category("4", "目录4", null, null);
        Category category5 = new Category("5", "目录5", null, null);
        Category category11 = new Category("11", "目录11", "1", null);
        Category category21 = new Category("21", "目录21", "2", null);
        Category category31 = new Category("31", "目录31", "3", null);
        Category category41 = new Category("41", "目录41", "4", null);
        Category category51 = new Category("51", "目录51", "5", null);
        Category category111 = new Category("111", "目录111", "11", null);
        Category category112 = new Category("112", "目录112", "11", null);
        Category category113 = new Category("113", "目录113", "11", null);
        Category category1111 = new Category("1111", "目录1111", "111", null);
        Category category211 = new Category("211", "目录211", "21", null);
        Category category212 = new Category("212", "目录212", "21", null);
        Category category2111 = new Category("2111", "目录2111", "211", null);
        list.add(category1);
        list.add(category2);
        list.add(category3);
        list.add(category4);
        list.add(category5);
        list.add(category11);
        list.add(category21);
        list.add(category31);
        list.add(category41);
        list.add(category51);
        list.add(category111);
        list.add(category112);
        list.add(category113);
        list.add(category1111);
        list.add(category211);
        list.add(category212);
        list.add(category2111);
        return list;
    }

    private String createString(){
        String str = "[\n" +
                "  {\n" +
                "    \"type\": \"org\",\n" +
                "    \"scopes\": [\n" +
                "      {\n" +
                "        \"name\": \"二级公司\",\n" +
                "        \"id\": \"2680312687628544\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"pcategory\",\n" +
                "    \"scopes\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"jobgrade\",\n" +
                "    \"scopes\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"jobrank\",\n" +
                "    \"scopes\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"staffstate\",\n" +
                "    \"scopes\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"changetype\",\n" +
                "    \"scopes\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"jobtype\",\n" +
                "    \"scopes\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"wagegroup\",\n" +
                "    \"scopes\": [\n" +
                "      {\n" +
                "        \"name\": \"100001\",\n" +
                "        \"id\": \"1451367116933955587\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"testGroup31\",\n" +
                "        \"id\": \"1451341080830148611\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"wageGroup4\",\n" +
                "        \"id\": \"1456808067389194244\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"type\": \"job\",\n" +
                "    \"scopes\": []\n" +
                "  }\n" +
                "]";
        return str;
    }
}
