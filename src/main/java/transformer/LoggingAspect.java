package transformer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* transformer.StringTransformer.transformString(..))")
    public Object logTransformedString(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object result = joinPoint.proceed();

        if (StringTransformer.isLoggingEnabled() && !joinPoint.getArgs()[0].toString().trim().isEmpty()) {
            logger.info("Логування: Початковий рядок: " + joinPoint.getArgs()[0]);
            logger.info("Логування: Перетворений рядок: " + result);
        }
        return result;
    }
}