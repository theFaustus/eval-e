package com.evil.inc.evale.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Pointcut(value = "within(@org.springframework.stereotype.Service *)")
    public void serviceLayer() {
    }

    @Pointcut(value = "within(@org.springframework.stereotype.Repository *)")
    public void repoLayer() {
    }

    @Pointcut(value = "within(@org.springframework.stereotype.Controller *)")
    public void webLayer() {
    }

//    @Before(value = "serviceLayer() || repoLayer() || webLayer()")
//    public void logBefore(JoinPoint joinPoint) {
//        log.info("Entered layer with before > {} ", joinPoint);
//    }
//
//
//    @After(value = "serviceLayer() || repoLayer() || webLayer()")
//    public void logAfter(JoinPoint joinPoint) {
//        log.info("Exited layer with after > {} ", joinPoint);
//    }

    @Around(value = "serviceLayer() || repoLayer() || webLayer()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Before layer with around > {} ", pjp);
        final Object returnValue = pjp.proceed();
        log.info("After layer with around > {} ",  pjp);
        return returnValue;
    }



}