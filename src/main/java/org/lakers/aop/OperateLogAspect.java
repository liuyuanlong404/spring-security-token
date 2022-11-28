package org.lakers.aop;

import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created on 2022/11/17 11:20
 *
 * @author lakers
 */
@Data
@Component
@Aspect
public class OperateLogAspect {

    private String desc;

    private String userId;

    @Pointcut("@annotation(org.lakers.aop.RecordOperate)")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 返回结果
        Object proceed = joinPoint.proceed();

        // 拿到方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RecordOperate annotation = signature.getMethod().getAnnotation(RecordOperate.class);

        Class<? extends LogConvert> convert = annotation.convert();
        OperateLog log = convert.newInstance().convert(joinPoint.getArgs()[0]);
        log.setDesc(annotation.desc());
        System.out.println("insert log :" + log);
        return proceed;
    }
}
