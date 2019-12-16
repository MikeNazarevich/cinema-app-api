package com.mikhail.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.mikhail.service.api.*.*(..))")
    public Object logServiceCall(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.debug("****LoggingAspect start service method: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        LOGGER.debug("***LoggingAspect finish method: " + joinPoint.getSignature().getName());

        return result;
    }
}
