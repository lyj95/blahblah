package com.blah.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	public void before(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(
								join.getTarget()+""); //대상객체
	
		logger.info("--------Aop Start-----");
		Object[] args = join.getArgs();
		if(args !=null) {
			logger.info("method: " + join.getSignature().getName());
			//대상 메서드의 정보
			for(int i=0; i<args.length; i++) {
				logger.info(i+"번째: "+args[i]);
			}
		}
		System.out.println("------before end-----");
	}
	
	public void after(JoinPoint join) {
		System.out.println("----after start----");
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("---------Aop End--------");
		
		
		
		
		
	}
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("-------Error Log------");
		logger.info("ERROR: " + join.getArgs());
		logger.info("ERROR: " + join.toString());
	}
}










