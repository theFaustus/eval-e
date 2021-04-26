package com.evil.inc.evale.config.aspect;

import com.evil.inc.evale.config.utils.SimpleProfiler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class ProfilingAspect {

    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        final SimpleProfiler simpleProfiler = new SimpleProfiler();
        simpleProfiler.setOrder(1);
        return simpleProfiler.profile(pjp);
    }

    @Pointcut("execution(public * *(..)) && com.evil.inc.evale.config.aspect.LoggingAspect.serviceLayer()")
    public void methodsToBeProfiled(){}
}