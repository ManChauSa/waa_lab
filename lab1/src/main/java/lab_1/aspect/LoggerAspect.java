package lab_1.aspect;

import lab_1.entity.ExceptionLogger;
import lab_1.entity.Logger;
import lab_1.repo.ExceptionLoggerRepo;
import lab_1.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    private LoggerRepo loggerRepo;

    @Autowired
    private ExceptionLoggerRepo exceptionLoggerRepo;

    private  static  final  String Principle ="fakeUser";
    private static Logger currentLogger = new Logger();

    //This point cut will execute where ever the annotation is placed
    @Pointcut("@annotation(lab_1.aspect.annotation.Log)")
    public void logAnnotation(){}


    public  void log(JoinPoint  joinpoint, String operation){
        //ToDo insert log to database
        Logger logger = new Logger();
        logger.setOperation(operation);
        logger.setPrinciple(Principle);
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        currentLogger = loggerRepo.save(logger);
    }

    @AfterThrowing(pointcut = "logAnnotation()", throwing = "exception")
    public void logException(JoinPoint joinpoint, Exception exception){
        ExceptionLogger exceptionLogger = new ExceptionLogger();
        exceptionLogger.setTransactionId(currentLogger.getTransactionId());
        exceptionLogger.setOperation(joinpoint.getSignature().getName());
        exceptionLogger.setPrinciple(Principle);
        exceptionLogger.setDate(LocalDate.now());
        exceptionLogger.setTime(LocalTime.now());
        exceptionLogger.setExceptionType(exception.getClass().getName());
        exceptionLoggerRepo.save(exceptionLogger);
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
