package org.lakers.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created on 2022/11/5 13:18
 *
 * @author lakers
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    private long startTime;
    @Pointcut("execution(public * org.lakers.controller..*.*(..))")
    public void controllerLog() {
    }


    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) {

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("****************************************************************************************");
        log.info("请求URL : " + request.getRequestURL());
        log.info("客户端ip [{}]", request.getRemoteAddr());
        log.info("请求映射 : 【{}】类的【{}】方法" , joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

        // 获取参数, 只取自定义的参数, 自带的HttpServletRequest, HttpServletResponse不管
        printArgs(joinPoint);
        startTime = System.currentTimeMillis();
    }

    private static void printArgs(JoinPoint joinPoint) {
        if (joinPoint.getArgs().length > 0) {
            for (Object o : joinPoint.getArgs()) {
                if (Objects.isNull(o) || o instanceof MultipartFile || o instanceof MultipartFile[] || o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
                    continue;
                }
                log.info("请求参数 :{} ", JSON.toJSONString(o));
            }
        }
    }


    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) {
        log.info("处理耗时:{}ms", System.currentTimeMillis() - startTime);
        // 处理完请求，返回内容
        log.info("返回 : {}", JSON.toJSONString(ret));
        log.info("请求结束 : " + "****************************************************************************************");
    }

}
