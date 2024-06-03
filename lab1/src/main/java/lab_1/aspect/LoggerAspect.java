package lab_1.aspect;

import lab_1.entity.Logger;
import lab_1.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    private LoggerRepo loggerRepo;
    private  static  final  String Principle ="fakeUser";

    //This point cut will execute where ever the annotation is placed
//    @Pointcut("@annotation(lab_1.aspect.annotation.Log)")
    @Pointcut("execution( * lab_1.controller.*(..))")
    public void logAnnotation(){}


    public  void log(JoinPoint  joinpoint, String operation){
        //ToDo insert log to database
        Logger logger = new Logger();
        logger.setOperation(operation);
        logger.setPrinciple(Principle);
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        loggerRepo.save(logger);
    }

    @Before("logAnnotation()")
    public void logBefore(JoinPoint joinPoint){
        log(joinPoint, "START");
    }

    @After("logAnnotation()")
    public  void logAfter( JoinPoint joinPoint){
        log(joinPoint,"END");
    }
}
