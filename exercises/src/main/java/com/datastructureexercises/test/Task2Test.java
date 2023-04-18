package com.datastructureexercises.test;

import com.datastructureexercises.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
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


    public static void main(String[] args) throws InterruptedException {
        double v_1 = 101.9;
        double v_2 = 91.2;
        double v_3 = 81.3;
        double v = v_1 + v_2 + v_3;
        System.out.println(v);
        String fileName = String.format("导出-%s.xls","hehe");
        System.out.println(fileName);
        List<User> userList = new ArrayList<>();
        User user_1 = new User();
        user_1.setId("1");
        user_1.setName("hahahah");
        user_1.setOrderId(1);
        user_1.setCreationTime(new Date());
        Thread.sleep(1000);
        User user_2 = new User();
        user_2.setId("1");
        user_2.setName("heheheh");
        user_2.setOrderId(2);
        user_2.setCreationTime(new Date());
        Thread.sleep(1000);
        User user_3 = new User();
        user_3.setId("1");
        user_3.setName("xixixix");
        user_3.setCreationTime(new Date());
        userList.add(user_1);
        userList.add(user_2);
        userList.add(user_3);
        userList = userList.stream().sorted(Comparator.comparing(User::getCreationTime,Comparator.nullsFirst(Date::compareTo)).reversed()).collect(Collectors.toList());
        log.info("userList:{}",userList);
        List<User> waStaffNumVOS = userList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()-> new TreeSet<>(Comparator.comparing(User::getId))),ArrayList::new));
        log.info("waStaffNumVOS:{}",waStaffNumVOS);
    }

    public static boolean isNeedParser(String formulastr) {
        Pattern numberPattern = compile("[0-9]*");
        boolean isneed = false;
        if (formulastr==null) {
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

    public static boolean isDate(String date) {
        if (date == null) {
            return false;
        }
        try {
            Date date1 = DateUtils.parseDate(date, "yyyy-MM-dd");
            System.out.println(date1);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Test
    public void test1() {
        Object date = new Date();
        String st = "F_N_20";
        String substring = st.substring(0, 4);
        log.info(substring);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        log.info("{}", format);
        Map<String, Set<String>> accountingDelegateBefore = new HashMap<>();
        Set<String> hello = accountingDelegateBefore.get("hello");
        System.out.println(hello);
        log.info("-------------------------");
        List<String> staffJobDtosUpdate = new ArrayList<>();
        //编辑前状态为update的任职信息Id
        List<String> updateOriginalIds = new ArrayList<>();
        //状态为update的任职信息被引用
        List<String> intersection = staffJobDtosUpdate.stream().filter(updateOriginalIds::contains).collect(Collectors.toList());
        log.info(intersection.toString());
        //状态为delete的任职信息被引用
        List<String> reduceList = staffJobDtosUpdate.stream().filter(m -> !intersection.contains(m)).collect(Collectors.toList());
        log.info(reduceList.toString());
        List<User> list = new ArrayList<>();
        List<String> collect = list.stream().map(User::getAge).collect(Collectors.toList());
        log.info(collect.toString());


    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("2022-10-01&2022-10-20");
        list.add("2022-10-26&");
        list.add("2022-10-21&2022-10-25");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    private Integer getSalaryLength(String number) {
        String[] split = number.split("\\.");
        if (split.length == 1) {
            return 0;
        } else {
            return split[1].length();
        }
    }
    @Test
    public void test3() {
        List<User> list = new ArrayList<>();
        List<User> list2 = new ArrayList<>();
//        list.add(new User("a", "2", "京"));
//        list.add(new User("a", "3", "沪"));
//        list.add(new User("a", "4", "辽"));
//        list.add(new User("b", "5", "黑"));
//        list.add(new User("b", "6", "蒙"));
//        list.add(new User("b", "7", "陕"));
//        list2.add(new User("b", "7", "陕"));
        HashMap<Object, Object> map = new HashMap<>();
        Object heh = map.get("heh");
        System.out.println(heh);
    }

    @Test
    public void test4() {
        for (int i = 0; i < 10; i++) {
            switch (i){
                case Utils.STAFF_CODE:
                    System.out.println("hehe");
                    break;
                case 1:
                    System.out.println("haha");
                    break;
                default:
                    System.out.println("xixi");
                    break;
            }
            System.out.println(i);
        }
    }

    private Integer test77(Integer num){
        return num;
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
        }
        log.info(itemCategoryList.toString());
    }

    @Test
    public void test6(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list2.add("B");
        String join = StringUtils.join(list1, ",");
        System.out.println("薪资核算的定调薪档案中引用了此任职信息,JOB_ID:{0}".replace("{0}",join));
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
