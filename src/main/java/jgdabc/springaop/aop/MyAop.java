package jgdabc.springaop.aop;

import jgdabc.springaop.entity.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAop {
//    @Before(value = "execution(public * jgdabc.service.Impl.*(..))")
//    ..在外是任意路径，在内是任意参数
//    访问类型为public,任意返回类型，任意路径，任意方法（任意参数）


//    使用pointcut做切面
    @Pointcut(value = "execution(public * *..*(..))")
    public void myBeforePointCut(){

    }
//
//    @Before(value = "execution(public * *..*(..))")//任意返回类型
    @Before("myBeforePointCut()")
    public void beforeAop()
    {
        System.out.println("前置切面执行");
    }

//     表达式 访问修饰符 返回类型修饰符 包 类 方法(参数)
//    @AfterReturning(value = "execution(public * jgdabc.service.Impl.serviceStudent())",returning = "res")
//    任意的访问修饰符类型，任意的返回值类型，..表示任意包路径，然后任意类，然后指定方法serviceStudent()
    @AfterReturning(value = "execution(* * ..*serviceStudent())",returning = "res")
    public void AfterReturningAop(Object res)
    {
        System.out.println("后置切面执行修改原方法返回student");
        if (res!=null)
        {
            Student res1 = (Student) res;
            res1.setName("daodaozi");
        }
    }
    @Around(value = "execution(* * ..serviceAroundAop(..))")
    public void AroundAop(ProceedingJoinPoint joinPoint){
//        前切
        Object[] args = joinPoint.getArgs();
        if (args[0].equals("张三"))
        {
//            权限校验通过
            Signature signature = joinPoint.getSignature();
            String name = signature.getName();
            System.out.println("权限校验通过 "+name+"执行");
        }else {
            System.out.println("您无权访问");
        }


    }
//    方法返回之前的
    @AfterReturning(value = "execution(* *..fterService())")
    public void testAfterReturning()
    {
        System.out.println("后置通知执行----");
    }
    @After(value = "execution(* * ..afterService())")

    public void afterAop()
    {
        System.out.println("最终通知执行");
    }



}

