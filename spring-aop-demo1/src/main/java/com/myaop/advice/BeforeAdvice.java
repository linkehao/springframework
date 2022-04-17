package com.myaop.advice;

public class BeforeAdvice extends BaseAdvice {
    @Override
    public Object execute(Chain chain) throws Throwable {


        System.out.println("前置通知");
        // 如果chain链中还有通知，则继续执行
        return chain.proceed();

    }
}
