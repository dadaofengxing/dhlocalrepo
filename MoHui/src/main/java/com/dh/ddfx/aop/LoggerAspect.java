package com.dh.ddfx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author duh
 * @create 2018/6/14 16:45
 * @email duh@elab-plus.com
 **/
@Aspect //声明为一个切面
@Component  //放到IOC容器中
@Order(1)  //设置切面的优先级：如果有多个切面，可通过设置优先级控制切面的执行顺序（数值越小，优先级越高）
public class LoggerAspect {

    /**
     * 使用@Pointcut  声明切入点表达式，一般为空方法
     * 后面的通知直接使用方法名来引用当前的切点表达式；若其他类使用，需加上包名
     */
    @Pointcut("execution (public * com.dh.ddfx.controller.*Controller.*(..))")
    public void declareJoinPointExpression(){
    }

    /**
     * 前置通知
     * @param point
     */
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint point){
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("this method "+ methodName+" begin. param< " + args + " >");
    }

    /**
     * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
     * @param point
     */
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint point){
        String methodName = point.getSignature().getName();
        System.out.println("this method "+ methodName+" end");
    }

    /**
     * 结果返回通知（在方法正常结束执行的代码）
     * 可以访问到方法的返回值 result1
     * @param point result1
     */
    @AfterReturning(value = "declareJoinPointExpression()",returning = "result1")
    public void afterReturnMethod(JoinPoint point,Object result1){
        String methodName = point.getSignature().getName();
        System.out.println("this method "+ methodName+" return result is "+result1);
    }

    /**
     * 异常通知
     * 可以访问到异常对象；且可以指定在出现特定异常时执行的代码
     * @param point
     * @param exception
     */
    @AfterThrowing(value = "declareJoinPointExpression()",throwing = "exception")
    public void afterThrowingMethod(JoinPoint point,Exception exception){
        String methodName = point.getSignature().getName();
        System.out.println("this method "+ methodName+" throwing exception message is "+exception.getMessage());
    }

    /**
     * 环绕通知(需要携带类型为ProceedingJoinPoint类型的参数)--参数与其他不同
     * 环绕通知包含前置、后置、返回、异常通知；ProceedingJoinPoin 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即目标方法的返回值
     * @param point
     */
    @Around(value="declareJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint point){

        Object result = null;
        String methodName = point.getSignature().getName();
        try {
            //前置通知
            System.out.println("around --- The method "+ methodName+" start. param<"+ Arrays.asList(point.getArgs())+">");
            //执行目标方法
            result = point.proceed();
            //返回通知
            System.out.println("around --- The method "+ methodName+" end. result<"+ result+">");
        } catch (Throwable e) {
            //异常通知
            System.out.println("around --- this method "+methodName+" end.ex message<"+e+">");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("around --- The method "+ methodName+" end.");
        return result;
    }
}
