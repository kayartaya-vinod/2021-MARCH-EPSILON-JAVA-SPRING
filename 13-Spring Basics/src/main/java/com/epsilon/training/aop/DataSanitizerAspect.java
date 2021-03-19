package com.epsilon.training.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class DataSanitizerAspect {

	public DataSanitizerAspect() {
		log.info("DataSanitizerAspect instantiated!");
	}

	@Around("execution (* com.epsilon..ProductDao.find*(double, double))")
	public Object checkAndSwap(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		double min = Double.parseDouble(args[0].toString());
		double max = Double.parseDouble(args[1].toString());
		if (min > max) {
			args = new Object[] { max, min };
		}
		return pjp.proceed(args);
	}
}
