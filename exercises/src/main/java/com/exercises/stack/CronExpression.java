package com.exercises.stack;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class CronExpression {
    public Object validateCronExpression(JSONObject variable) {
        JSONArray resultList = new JSONArray();
        JSONObject result = new JSONObject();
        String code = variable.getString("pvCode");
        String message = "";
        String value = "";
        List<String> dateString = new ArrayList<String>();
        try {
            CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
            cronTriggerImpl.setCronExpression(code);
            // 指定获取最近几次的运行时间，这里指定为5次;
            List<Date> dates = TriggerUtils.computeFireTimes(cronTriggerImpl, null, 5);
            for (Date date : dates) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = formatter.format(date);
                dateString.add(format);
            }
            value = dateString.toString();
            result.putAll(variable);
            result.put("status", true);
            result.put("value", value);
            result.put("message", "");
        } catch (Exception e) {
            message = e.getMessage().length() > 50 ? e.getMessage().substring(0, 50) : e.getMessage();
//            log.error("", e);
            result.putAll(variable);
            result.put("status", false);
            result.put("value", "");
            result.put("message", message);
        } finally {
            resultList.add(result);
        }

        return resultList;
    }

    @Test
    public void getCronRunTimeTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "{\"pvCode\": \"00/5 14 * * ?\"}";
        Map map = objectMapper.readValue(str, Map.class);
        log.error(map.toString());
    }

}
