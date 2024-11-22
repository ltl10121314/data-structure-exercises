package com.exercises.jwt;

import net.sf.json.JSONObject;

import java.nio.charset.StandardCharsets;
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
        userInfo = Base64.getEncoder().encodeToString(obj.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println("userInfo:"+userInfo);
    }
}
