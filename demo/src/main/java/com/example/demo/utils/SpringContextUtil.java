package com.example.demo.utils;

import org.springframework.context.ApplicationContext;

public class SpringContextUtil {

    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}
