package com.sudarshan.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.sudarshan..*.*(..))")
	private void anyOperation() {}
	
	@Pointcut("within(com.sudarshan..*.*)")
	private void myOperation() {}
	
	@Pointcut("anyOperation() && myOperation()")
	private void myAppOperation() {}
	
	@Before("anyOperation()")
	@Order(1)
	private void beforeMethodLogging(JoinPoint joinPoint) {
		
		logger.info("Before_Method Class name : {}", joinPoint.getTarget().getClass().getName());
		
		logger.info("Before_Method Method name : {}", joinPoint.getSignature().getName());
		
		String[] paramNames =  ((MethodSignature)joinPoint.getSignature()).getParameterNames();
		
		for(String paramName:paramNames){
			logger.info("Before_Method Parameter name : {}", paramName);
        }
		
		Object[] paramValues = joinPoint.getArgs();

		for (Object object:paramValues){
			logger.info("Before_Method Parameter value : {}", object);
		}
		
	}
	
	@AfterReturning(pointcut="anyOperation()", returning="result")
	@Order(2)
	private void afterMethodReturnLogging(JoinPoint joinPoint, Object result) {
		logger.info("After_Method Class name : {}", joinPoint.getTarget().getClass().getName());
		logger.info("After_Method Method name : {}", joinPoint.getSignature().getName());
		logger.info("After_Method Return value : {}", result);
	}

}
