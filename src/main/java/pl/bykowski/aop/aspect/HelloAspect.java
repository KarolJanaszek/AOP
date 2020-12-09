package pl.bykowski.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    //Lepiej robić przez annotacje, bo wiadomo, że przejmuje metode aspekt i nie trzeba sie martwić o ścieżkę

    //Przed Hello
    @Before("@annotation(pl.bykowski.aop.aspect.HelloAspectAnnotation)")
    private void beforeHello() {
        System.out.println("Before Hello.");
    }

    //Po Hello
    @After("@annotation(pl.bykowski.aop.aspect.HelloAspectAnnotation)")
    private void afterHello() {
        System.out.println("After Hello.");
    }

//    //Around: albo przejmuje logike moteody wskazanej, albo występuję razmem z metodą wskazaną. Domyślnie przejmuje.
//    @Around("execution(String pl.bykowski.aop.Hello.sayHello())")
//    private void aroundHello() {
//        System.out.println("Around Hello.");
//    }

    //Aby dodać do metody Around dalszą logikrę robimy tak:
    @Around("@annotation(pl.bykowski.aop.aspect.HelloAspectAnnotation)")
    private void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Hello.");
        joinPoint.proceed();
    }


}
