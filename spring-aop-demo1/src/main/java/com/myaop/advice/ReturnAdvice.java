package com.myaop.advice;

public class ReturnAdvice extends BaseAdvice {
    @Override
    public Object execute(Chain chain) throws Throwable {
        Object proceed = chain.proceed();
//        如果没有异常则执行返回通知
        System.out.println("返回通知");
        return null;
    }
}
