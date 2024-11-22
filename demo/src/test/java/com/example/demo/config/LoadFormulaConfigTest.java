package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class LoadFormulaConfigTest {

    @Test
    public void test() {
        LoadFormulaConfig instance = LoadFormulaConfig.getInstance();
        String waitemDoc = instance.getBeanName("waitemDoc");
        String convertBeanName = instance.getConvertBeanName("waitemDoc");
        System.out.println(waitemDoc);
        System.out.println(convertBeanName);
    }

    @Test
    public void test1() {
        String str = "busiFun('daysRange','0','1','1','12','23')  +  busiFun('daysRange','0','2','1')  +  busiFun('jrworkcalendardate')";
        String[] split = str.split("\\+|\\-");
        for (String s : split) {
            System.out.println("公式:" + s);
            String[] split1 = s.split("'");
            for (int i = 0; i < split1.length; i++) {
                String string = split1[i];
                System.out.println("第" + i + "个:" + string);
            }
        }
    }

    @Test
    public void test2(){
        String payfileFormula = "busiFun('daysRange','0','1','1')  +  busiFun('daysRange','0','2','1')  +  busiFun('jrworkcalendardate')";
        String[] strS = payfileFormula.split("daysRange");
        List<String[]> list = new ArrayList<>();
        if(strS.length < 2){
            System.out.println(list);
        }
        for (int i = 1; i < strS.length; i++) {
            list.add(strS[i].split("'"));
        }
        for (String[] formula : list) {
            String formula2 = formula[2];
            String formula4 = formula[4];
        }
    }
}
