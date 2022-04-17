package com.myaop.advice;

public abstract class BaseAdvice {

    public abstract Object execute(Chain chain) throws Throwable;
}
