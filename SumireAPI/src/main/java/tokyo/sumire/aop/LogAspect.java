package tokyo.sumire.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tokyo.sumire.constant.LogConstant;

@Aspect
@Component
@Slf4j
public class LogAspect {

	@Before("execution(* tokyo.sumire.controller.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		log.info(String.format(LogConstant.I_LOG001, jp.getSignature().toString()));
		log.info(String.format(LogConstant.I_LOG002, getPayload(jp)));
	}

	@AfterReturning(pointcut = "execution(* tokyo.sumire.controller.*Controller.*(..))", returning = "res")
	public void endLog(JoinPoint jp, Object res) {
		log.info(String.format(LogConstant.I_LOG003, res.toString()));
		log.info(String.format(LogConstant.I_LOG004, jp.getSignature().toString()));
	}

	private String getPayload(JoinPoint jp) {
		var signature = (CodeSignature) jp.getSignature();
		var builder = new StringBuilder();

		for (int i = 0; i < jp.getArgs().length; i++) {
			builder.append(signature.getParameterNames()[i]);
			builder.append(": ");
			builder.append(jp.getArgs()[i].toString());
			if (i != jp.getArgs().length - 1) {
				builder.append(",");
			}
		}
		return builder.toString();
	}

}
