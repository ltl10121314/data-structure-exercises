package com.example.demo.interceptor;

import org.apache.ibatis.executor.resultset.ResultSetWrapper;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.util.Properties;

@Intercepts({@Signature(
        type = ResultHandler.class,
        method = "handleResultSets",
        args = {ResultSetWrapper.class}
)})
public class MyResultHandlerInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        ResultSetWrapper rsw = (ResultSetWrapper) invocation.getArgs()[0];
        // 在这里可以访问或修改typeHandlerMap等属性
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
