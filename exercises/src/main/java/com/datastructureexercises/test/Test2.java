package com.datastructureexercises.test;


import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Hobby hobby_1 = new Hobby();
        hobby_1.setHobbyId(1);
        hobby_1.setHobbyName("跑步");
        Set<Hobby> hobbies = new HashSet<>();
        hobbies.add(hobby_1);
        Nurse nurse_1 = new Nurse();
        nurse_1.setId(1);
        nurse_1.setName("西西");
        nurse_1.setAge(18);
        nurse_1.setContent("haha");
        nurse_1.setHobbies(hobbies);
        HashSet<Nurse> nurses = new HashSet<>();
        nurses.add(nurse_1);
        hobby_1.setNurses(nurses);

    }

    public static String getCurrentMonthlastday(String n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date parse = null;
        try {
            parse = sdf.parse(n);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar cale = Calendar.getInstance();
        cale.setTime(parse);
        cale.set(Calendar.DATE, cale.getActualMaximum(Calendar.DATE));
        SimpleDateFormat sdfm = new SimpleDateFormat("yyyyMMdd");
        return sdfm.format(cale.getTime());
    }

   
}
