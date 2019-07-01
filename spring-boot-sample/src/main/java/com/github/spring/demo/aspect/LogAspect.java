package com.github.spring.demo.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spring.demo.annotation.Log;
import com.github.spring.demo.utils.HttpContextUtil;
import com.github.spring.demo.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    ObjectMapper objectMapper;

    @Pointcut("@annotation(com.github.spring.demo.annotation.Log)")
    public void pointcut() {
        // do nothing
    }

    @Before("pointcut()")
    public void before() {
        log.info("已经记录下操作日志@Before 方法执行前");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws JsonProcessingException {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        // 获取 request
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        // 设置 IP 地址
        String ip = IPUtil.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        // 请求的类名
        String className = point.getTarget().getClass().getName();

        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);

        log.info(">>className=" + className);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));

            log.info(">>param=" + params.toString());
        }

        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            log.info(">>remark="+logAnnotation.value());
        }

        return result;
    }

    @After("pointcut()")
    public void after() {
        log.info("已经记录下操作日志@After 方法执行后");
    }

    private StringBuilder handleParams(StringBuilder params, Object[] args, List paramNames) throws JsonProcessingException {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Map) {
                Set set = ((Map) args[i]).keySet();
                List<Object> list = new ArrayList<>();
                List<Object> paramList = new ArrayList<>();
                for (Object key : set) {
                    list.add(((Map) args[i]).get(key));
                    paramList.add(key);
                }
                return handleParams(params, list.toArray(), paramList);
            } else {
                if (args[i] instanceof Serializable) {
                    Class<?> aClass = args[i].getClass();
                    try {
                        aClass.getDeclaredMethod("toString", new Class[]{null});
                        // 如果不抛出 NoSuchMethodException 异常则存在 toString 方法 ，安全的 writeValueAsString ，否则 走 Object的 toString方法
                        params.append(" ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i]));
                    } catch (NoSuchMethodException e) {
                        params.append(" ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i].toString()));
                    }
                } else if (args[i] instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) args[i];
                    params.append(" ").append(paramNames.get(i)).append(": ").append(file.getName());
                } else {
                    params.append(" ").append(paramNames.get(i)).append(": ").append(args[i]);
                }
            }
        }
        return params;
    }

}
