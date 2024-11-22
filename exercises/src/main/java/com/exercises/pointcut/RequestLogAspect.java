//package com.datastructureexercises.pointcut;
//
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class RequestLogAspect {
//    private final static Logger Logger = LoggerFactory.getLogger(RequestLogAspect.class);
//
//    @Pointcut("execution(* your_package.controller..*(..))")
//    public void requestServer() {
//    }
//
//    @Before("requestServer()")
//    public void doBefore(JoinPoint joinPoint) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes)
//                RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        Logger.info("===============================Start========================");
//        Logger.info("IP                 : {}", request.getRemoteAddr());
//        Logger.info("URL                : {}", request.getRequestURL().toString());
//        Logger.info("HTTP Method        : {}", request.getMethod());
//        Logger.info("Class Method       : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName());
//    }
//
//
//    @Around("requestServer()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object result = proceedingJoinPoint.proceed();
//        Logger.info("Request Params     : {}", getRequestParams(proceedingJoinPoint));
//        Logger.info("Result               : {}", result);
//        Logger.info("Time Cost            : {} ms", System.currentTimeMillis() - start);
//
//        return result;
//    }
//
//    @After("requestServer()")
//    public void doAfter(JoinPoint joinPoint) {
//        Logger.info("===============================End========================");
//    }
//
//    /**
//     * 获取入参
//     * @param proceedingJoinPoint
//     *
//     * @return
//     * */
//    private Map<String, Object> getRequestParams(ProceedingJoinPoint proceedingJoinPoint) {
//        Map<String, Object> requestParams = new HashMap<>();
//
//        //参数名
//        String[] paramNames =
//                ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterNames();
//        //参数值
//        Object[] paramValues = proceedingJoinPoint.getArgs();
//
//        for (int i = 0; i < paramNames.length; i++) {
//            Object value = paramValues[i];
//
//            //如果是文件对象
//            if (value instanceof MultipartFile) {
//                MultipartFile file = (MultipartFile) value;
//                value = file.getOriginalFilename();  //获取文件名
//            }
//
//            requestParams.put(paramNames[i], value);
//        }
//
//        return requestParams;
//    }
//}
