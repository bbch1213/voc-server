package com.board.api.common.config.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.board.api.*.service..*(..))")
    private void Target() {

    }

    @Around("Target()")
    public Object AccountLog(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("service start");

        Object result = pjp.proceed();

        logger.info("service terminated");

        return result;
    }
}
