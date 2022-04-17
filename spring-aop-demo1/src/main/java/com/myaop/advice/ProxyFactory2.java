package com.myaop.advice;

import com.myaop.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Factory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ProxyFactory2 implements MethodInterceptor {

    private Object target;

    // 通常是ioc自动注入的，但是没有实现ioc，所以先写死
    private List<BaseAdvice> adviceList;

    public ProxyFactory2 () {
        adviceList = new ArrayList<BaseAdvice>();
        adviceList.add(new ThrowAdvice());
        adviceList.add(new ReturnAdvice());
        adviceList.add(new AfterAdvice());
        adviceList.add(new BeforeAdvice());
    }

    public Object getProxy(Object obj) {
        target = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        enhancer.setClassLoader(obj.getClass().getClassLoader());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Chain chain = new Chain(adviceList, method, objects, target);
        return chain.proceed();
    }
}
