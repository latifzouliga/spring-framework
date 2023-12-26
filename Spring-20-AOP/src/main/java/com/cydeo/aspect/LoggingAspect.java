package com.cydeo.aspect;


import com.cydeo.controller.CourseController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {
    // some code
}
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //     logging all method in CourseController class

    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))") // pointcut expression
    private void pointCut(){} // pointcut signature

    @Before("pointCut()")
    public void log(){
        logger.info("\n\nLogger info -----");
    }

   //    combining @PointCut and @ Before in one method
    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void beforeAdvice(){
        logger.info("Combing @pointCut and @Before: Logger info -----");
    }

     //logging one method only
    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    private void courseById() {
    }

    @Before("courseById()")
    public void beforeCourseById(JoinPoint joinPoint) {
        logger.info(
                "Before [Logging one method only] (findById) : -> Method: {} - Argument: {} - Target: {}",
                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

     //within
    @Pointcut("within(com.cydeo.controller.*)") // monitor class level
    private void anyController() {
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceOperation() {
    }


    @Before("anyController() || anyServiceOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint) {
        logger.info("Before [2 pointcuts] -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

     //monitor @DeleteMapping annotation
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)") // monitor method level
    private void anyDeleteCourseOperation(){
    }

    @Before("anyDeleteCourseOperation()")
    public void beforeControlAdvice(JoinPoint joinPoint){
        logger.info("Before [monitor @Delete annotation] -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }


    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation() {
    }

    // getting one result
    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result) {
        logger.info("After returning [returning a result] -> Method: {} - result: {}", joinPoint.getSignature().toShortString(), result.toString());
    }

    // getting list of results
    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result) {
        logger.info("After returning [Returning a list of results] -> Method: {} - result: {}", joinPoint.getSignature().toShortString(), result.toString());
    }

    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, RuntimeException exception) {
        logger.info("after Throwing [Monitoring an exception] -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    @After("anyGetCourseOperation()")
    public void after(JoinPoint joinPoint) {
        logger.info("After finally -> Method: {}", joinPoint.getSignature().toShortString());
    }


    @Pointcut("@annotation(com.cydeo.annotation.Loggable)")
    private void anyLoggableMethod() {
    }

    @Around("anyLoggableMethod()")
    public Object anyLoggableMethodOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // monitor before execution
        logger.info("Before [Around] -> Method: {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint);

        Object results = proceedingJoinPoint.proceed();

        // monitor before execution
        logger.info("After [Around] -> Method: {} - Result: {}", proceedingJoinPoint.getSignature().toShortString(), results);

        return results;
    }


}
