package ru.alexraydev.javaspring09.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Pointcut("within(ru.alexraydev.javaspring09.aop.*)")
    public void pointcutDemo() {}


    @Before("pointcutDemo()")
    public void withinDemoAdvice(JoinPoint joinPoint) {
        System.out.println("******** BEFORE DEMO ********");
        for (Object obj : joinPoint.getArgs()) {
            System.out.println("Arg: " + obj);
        }
    }
}
