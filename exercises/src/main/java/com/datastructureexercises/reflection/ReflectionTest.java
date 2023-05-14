package com.datastructureexercises.reflection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    /**
     * 测试
     *
     * @param name
     */
    void morning(String name);
}

/**
 * @author liutianlong
 */
public class ReflectionTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionTest.class);

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LOGGER.info(method.toString());
                if ("morning".equals(method.getName())) {
                    LOGGER.info("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                // 传入ClassLoader
                Hello.class.getClassLoader(),
                // 传入要实现的接口
                new Class[]{Hello.class},
                // 传入处理调用方法的InvocationHandler
                handler);
        hello.morning("Bob");
    }

    @Test
    public void test1() throws ClassNotFoundException {
        Class<String> stringClass = String.class;
        Class string = Class.forName("java.lang.string");
    }
}

