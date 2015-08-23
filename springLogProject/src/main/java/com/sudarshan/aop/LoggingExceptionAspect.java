package com.sudarshan.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingExceptionAspect {
	
	private Logger logger = LoggerFactory.getLogger(LoggingExceptionAspect.class);
	
	@AfterThrowing(pointcut="execution(* com.sudarshan..*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		logger.info("Exception Method Join point kind : {}", joinPoint.getKind());
		logger.info("Exception Method Signature type : {}", joinPoint.getSignature().getDeclaringTypeName());
		logger.info("Exception Method Signature name : {}", joinPoint.getSignature().getName());
		logger.info("Exception Method Arguments present: {}", Arrays.toString(joinPoint.getArgs()));
		logger.info("Exception Class name : {}", joinPoint.getTarget().getClass().getName());
		logger.error("Exception is : {}", e);
	}
}
