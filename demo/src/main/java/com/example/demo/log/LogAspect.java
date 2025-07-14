package com.example.demo.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.example.demo.log.MyLog)")
    public void myLockPointcut() {

    }

    @Around("myLockPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前置逻辑
        log.error("Before method execution with myLog annotation");
        // 执行目标方法
        Object result = joinPoint.proceed();
        // 后置逻辑
        log.error("After method execution with myLog annotation");
        return result;
    }

    @Pointcut("execution(* com.example.demo.service..*(..))")
    public void serviceMethods() {

    }

    @Before("serviceMethods()")
    public void beforeServiceMethods(JoinPoint joinPoint) {
        log.error("Before service method execution");
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterServiceMethods(JoinPoint joinPoint, Object result) {
        log.error("After service method execution, result: {}", result);
    }

    @Around("@annotation(com.example.demo.log.MyLog)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作时间
        Date operateTime = new Date();
        //操作类名
        String className = joinPoint.getTarget().getClass().getName();
        //操作方法名
        String methodName = joinPoint.getSignature().getName();
        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        long begin = System.currentTimeMillis();
        //调用原始目标方法运行
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //方法返回值
        ObjectMapper mapper = new ObjectMapper();
        String returnValue = mapper.writeValueAsString(result);
        //操作耗时
        long costTime = end - begin;
        //记录操作日志
        log.error("操作时间:{} 操作类名:{} 操作方法名:{}  操作方法参数:{}  方法返回值:{}  操作耗时{}", operateTime, className, methodName, methodParams, returnValue, costTime);
        return result;
    }

    @AfterReturning(
            value = "@annotation(com.example.demo.log.MyLog)",
            returning = "returnValue"
    )
    public void returnValuePointcut(JoinPoint joinPoint, final Object returnValue) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
//        log.error(method.getName());
//        log.error(returnValue.toString());
    }
}
