package com.fzt.boot.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求的日志处理
 * Created by Donghua.Chen on 2018/4/28.
 */
@Aspect
@Component
@Configuration
public class WebLogAspect {

    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    private ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    @Pointcut("execution(public * com.fzt.boot.controller.*.*(..))")
    public void webLog(){}


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){

        //接收到请求，记录请求内容
        logger.warn("【BEGIN TIME】 -> {}", sdf.format(new Date()));
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        Map<String, Object> params = buildContext(joinPoint);
        logger.warn("【URL】-> {}", request.getRequestURL().toString());
        logger.info("【HTTP_METHOD】-> {}", request.getMethod());
        logger.info("【IP】-> {}", request.getRemoteAddr());
        logger.info("【CLASS_METHOD】-> {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.warn("【PARAMS】 -> {}", params);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        //处理完请求，返回内容
        logger.info("【RESPONSE】-> {}", ret);
        logger.info("【USE TIME】-> {}", (System.currentTimeMillis() - startTime.get()));
        logger.info("【END TIME】-> {}", sdf.format(new Date()));
        startTime.remove();//用完之后记得清除，不然可能导致内存泄露;
    }

    protected Map<String, Object> buildContext(JoinPoint jp){
        Map<String, Object> context = new HashMap<>();
        Object[] args = jp.getArgs();
        String[] paramNames = getParameterNames(jp);
        if (paramNames == null) {
            logger.warn("Unable to resolve method parameter names for method: " + jp.getStaticPart().getSignature()
                    + ". Debug symbol information is required if you are using parameter names in expressions.");
        } else {
            for (int i = 0; i < args.length; i++)
                context.put(paramNames[i], args[i]);
        }

        return context;
    }

    /**
     * 获取参数名
     * @param jp
     * @return
     */
    private String[] getParameterNames(JoinPoint jp) {
        if (!jp.getKind().equals(JoinPoint.METHOD_EXECUTION))
            return null;
        Class<?> clz = jp.getTarget().getClass();
        MethodSignature sig = (MethodSignature) jp.getSignature();
        Method method;
        try {
            method = clz.getDeclaredMethod(sig.getName(), sig.getParameterTypes());
            if (method.isBridge())
                method = BridgeMethodResolver.findBridgedMethod(method);
            return getParameterNames(method);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取所有参数名字
     * @param method
     * @return
     */
    private String[] getParameterNames(Method method) {
        Annotation[][] annotations = method.getParameterAnnotations();
        String[] names = new String[annotations.length];
        String[] namesDiscovered = parameterNameDiscoverer.getParameterNames(method);
        if (namesDiscovered == null)
            return null;
        for (int i = 0; i < names.length; i++)
            if (names[i] == null)
                names[i] = namesDiscovered[i];
        return names;
    }

}
