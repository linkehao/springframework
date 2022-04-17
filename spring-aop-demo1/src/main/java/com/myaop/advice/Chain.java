package com.myaop.advice;

import java.lang.reflect.Method;
import java.util.List;

public class Chain {

    private List<BaseAdvice> adviceList;

    private int index = -1;

    // 目标方法
    private Method method;
    // 目标方法的参数
    private Object[] args;
    // 目标对象
    private Object target;

    public Chain(List<BaseAdvice> adviceList, Method method, Object[] args, Object target) {
        this.adviceList = adviceList;
        this.method = method;
        this.args = args;
        this.target = target;
    }

    public Object proceed() throws Throwable {

        // 递归结束条件
        if (index == adviceList.size() - 1) {
            // 通过反射调用目标方法
            return method.invoke(target, args);
        }


        return adviceList.get(++index).execute(this);
    }
}
