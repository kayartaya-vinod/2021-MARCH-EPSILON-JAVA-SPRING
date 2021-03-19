package com.epsilon.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // qualifies for component-scan
@Aspect // now, this is a special class, which is managed by AspectJ
public class LoggerAspect {

	public LoggerAspect() {
		log.info("LoggerAspect instantiated!");
	}
	
	// before advice
	// ModifierPattern? ReturnType PackagePattern.ClassOrInterfacePattern.MethodPattern(ArgPattern)
	@Before("execution (* com.epsilon..ProductDao.*(..))")
	public void logBefore(JoinPoint jp) { // dependency injection
		log.info("entering {}() method with arguments - {}",
				jp.getSignature().getName(), 
				jp.getArgs());
	}
	
	// after advice
	@After("execution (* com.epsilon..ProductDao.*(..))")
	public void logAfter(JoinPoint jp) {
		log.info("exiting {}()  mehtod...", jp.getSignature().getName());
	}
}
