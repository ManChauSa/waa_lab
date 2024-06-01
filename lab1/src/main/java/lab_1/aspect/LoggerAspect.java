package lab_1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    private  static  final  String Principle ="fakeUser";
    @Pointcut("execution(*lab_1.controller.*(..))")
    public  void log(JoinPoint  joinpoint, String operation){
        //ToDo insert log to database


    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        log(joinPoint, "START");
    }

    @After("log()")
    public  void logAfter( JoinPoint joinPoint){
        log(joinPoint,"END");
    }
}
