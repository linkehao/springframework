package com.myaop.advice;

public class AfterAdvice extends BaseAdvice {
    @Override
    public Object execute(Chain chain) throws Throwable {
        try {
            return chain.proceed();
        } finally {
            System.out.println("后置通知");
        }
    }
}
