package com.epsilon.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.epsilon.training.dao.DaoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ExceptionTransformerAspect {
	public ExceptionTransformerAspect() {
		log.info("ExceptionTransformerAspect instantiated!");
	}

	
	@AfterThrowing(pointcut = "execution (* com.epsilon..*Dao.*(..))", throwing = "ex")
	public void transform(JoinPoint jp, Exception ex) throws DaoException {
		log.warn("There wan an exception while calling {}() with {} parameters - {}", 
				jp.getSignature().getName(), 
				jp.getArgs(),
				ex.getMessage());
		throw new DaoException(ex);
	}
}
