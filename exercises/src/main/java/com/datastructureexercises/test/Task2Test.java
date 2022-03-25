package com.datastructureexercises.test;

import com.yonyou.hrcloud.formula.helper.FormulaAnalysisMasterCache;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author liutianlong
 */
public class Task2Test {
    static Map<String, Map<String, Object>> allDatas = new ConcurrentHashMap<>();
    private static FormulaAnalysisMasterCache master = new FormulaAnalysisMasterCache();

    public static void main(String[] args) {
//        boolean flag = isNeedParser("busiFun('insuranceManage','ta78l1k2category00001','92a7ff42532344dbb164d6a903ec233f')  +  busiFun('insuranceManage','ta78l1k2category00001','7436fd8cc1d64e789dc717688a46725d')");
//        System.out.println(flag);
        String express = " busiFun('insuranceManage','0000KWQ2SFG0B91B9D0000category00001','5d04aed8-540c-11ec-b20a-98039b2ede02')  +  busiFun('insuranceManage','0000KWQ2SFG0B91B9D0000category00001','5d049050-540c-11ec-b20a-98039b2ede02') ";
        String staffId = "41145718407836672";
        Map<String, Object> context = new HashMap<>();
        Map<String, Object> bindData = new HashMap<>();
        bindData.put("context", context);
//        bindData.put("allDatas", allDatas);
        bindData.put("staffId", staffId);
        Object o = master.parseExpr(express, bindData);
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
}
