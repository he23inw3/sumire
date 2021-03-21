package tokyo.sumire.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LogAspect {

	@Before("execution(* tokyo.sumire.controller.*.*(..))")
	public void startLog(JoinPoint jp) {
		log.info("メソッド開始： " + jp.getSignature());
	}

	@After("execution(* tokyo.sumire.controller.*.*(..))")
	public void endLog(JoinPoint jp) {
		log.info("メソッド終了： " + jp.getSignature());
	}
}
