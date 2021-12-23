package com.datastructureexercises.jwt;

import net.sf.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class JWTtoken {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.element("oid", "1");
        obj.element("userName", "administrator");
        obj.element("tenantId", "tenant_system");
        obj.element("loginId", "");
        obj.element("isAdmin", "");
        obj.element("roles", "");
        String userInfo = null;
        try {
            userInfo = Base64.getEncoder().encodeToString(obj.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("userInfo:"+userInfo);
    }
}
