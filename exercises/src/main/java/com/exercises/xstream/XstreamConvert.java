package com.exercises.xstream;

import com.alibaba.fastjson.JSONArray;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

/**
 * @author Administrator
 */
public class XstreamConvert {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        //声明XStream注解来源
        xStream.processAnnotations(FuiouResponse.class);
        //xml 转bean
//        Object o = xStream.fromXML(xmlStr);
//        //bean 转xml
//        xStream.toXML(response);
        JSONArray extAttrList = new JSONArray();
        if(extAttrList.isEmpty()){
            System.out.println("--------------");
        }
        ArrayList<Object> objects = new ArrayList<>();
        boolean empty = objects.isEmpty();
        System.out.println(empty);
    }
}
