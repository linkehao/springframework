package com.myaop.advice;

public class ThrowAdvice extends BaseAdvice {
    @Override
    public Object execute(Chain chain) throws Throwable {
        try {
            return chain.proceed();
        } catch (Exception e) {
            System.out.println("异常通知");
            throw e;
        }
    }
}
