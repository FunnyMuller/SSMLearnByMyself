package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before:前置通知，在目标对象方法执行之前执行
 * @After:后置通知，在finally中执行
 * @AfterReturing:返回通知，在返回值之后
 * @AfterThrowing:异常通知，在目标对象方法的catch子句中执行
 * 切入点表达式:设置在标识通知的注解的value属性中
 *execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))
 * com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))
 * 第一个*表示仁已的访问修饰符和返回值类型
 * 第二个*表示类中任意的方法
 *
 * 获取连接点的信息
 * 在通知方法的参数位置，设置JoinPoint类型的参数
 * //获取连接点所对应的方法的签名信息
 * Signature signature = joinPoint.getSignature();
 * //获取连接点所对应方法的参数
 * Object[] args = joinPoint.getArgs();
 **/
@Component
//将当前组件标识为切面
@Aspect
public class LoggerAspect {
    @Pointcut("execution(* com.atguigu.spring.aop.annotation.*.*(..))")
    public void pointCut(){}
//    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))")
//    @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应的方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法:" +signature.getName()+",参数："+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() +",执行完毕！");
    }

    /**
     * 在返回通知中获取目标对象方法的返回值
     * 只需要通过@AfterReturning注解的returning属性
     * 就可以将通知方法的某个参数指定为接受目标对象方法的返回值的参数
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",结果:"+ result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:"+signature.getName()+",异常:" + ex);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-前置通知");
            result = joinPoint.proceed();
            System.out.println("环绕通知-返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-异常通知");
        }finally{
            System.out.println("环绕通知-后置通知");
        }
        return result;
    }
}
