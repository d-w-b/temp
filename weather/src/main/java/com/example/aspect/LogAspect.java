package com.example.aspect;

import com.example.service.ILogService;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect
{
    private final ILogService logger;

    @Autowired
    public LogAspect(ILogService logService)
    {
        this.logger = logService;
    }

    @Pointcut("within(com.example.controller.*)")
    public void logMethods()
    {
        // 빈 메서드로 실제 동작은 없고, 포인트컷만 정의됩니다.
    }

    @Before("logMethods()")
    public void logMethodExecution(JoinPoint joinPoint) throws Throwable
    {
        String Msg = "Method " + joinPoint.getSignature().getName() + " invoked.";
        logger.Write(Msg);
    }

    @AfterReturning(value = "logMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) throws Throwable
    {
        String Msg = "Method " + joinPoint.getSignature().getName() + " finished successfully";
        logger.Write(Msg);
    }

    @AfterThrowing(value = "logMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) throws Throwable
    {
        String Msg = "Method " + joinPoint.getSignature().getName() + " threw an exception " + exception.getMessage();
        logger.Write(Msg);
    }
}
