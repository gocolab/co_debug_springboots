package com.test.codingtest_springboots.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
// @Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    // com.test.codingtest_springboots.service.*Service.*(..)
    @Before(value = "execution(* com.test.codingtest_springboots.service.*Service.insert*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering " + joinPoint.getTarget().getClass().getSimpleName()
                + "'s" + joinPoint.getSignature().getName()); // class name and method name
        Object[] args = joinPoint.getArgs(); // params
        for (int i = 0; i < args.length; i++) {
            logger.info("LoggingAspect args[" + i + "] --> " + args[i]);
        }
    }
}