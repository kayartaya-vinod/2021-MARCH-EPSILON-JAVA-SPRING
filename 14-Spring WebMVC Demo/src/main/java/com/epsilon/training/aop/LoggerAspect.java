package com.epsilon.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // qualifies for component-scan
@Aspect // now, this is a special class, which is managed by AspectJ
public class LoggerAspect {

	public LoggerAspect() {
		log.debug("LoggerAspect instantiated!");
	}
	
	@Pointcut("execution (* com.epsilon..ProductDao.*(..))")
	public void pc1() {}
	
	@Pointcut("execution (* com.epsilon..ProductController.*(..))")
	public void pc2() {}
	
	// before advice
	// ModifierPattern? ReturnType PackagePattern.ClassOrInterfacePattern.MethodPattern(ArgPattern)
	@Before("pc1() || pc2()")
	public void logBefore(JoinPoint jp) { // dependency injection
		log.debug("entering {}.{}() method with arguments - {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), 
				jp.getArgs());
	}
	
	// after advice
	@After("pc1() || pc2()")
	public void logAfter(JoinPoint jp) {
		log.debug("exiting {}.{}()  mehtod...", 
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName());
	}
}
