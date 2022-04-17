package com.myaop;

import com.myaop.advice.*;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws Throwable {
        UserService userService = new UserService();
//        userService.insert();

//        UserService proxy = (UserService) new ProxyFactory().getProxy(userService);
//        proxy.insert();


//        List<BaseAdvice> adviceList = new ArrayList<BaseAdvice>();
//        Chain chain = new Chain(adviceList);
//        adviceList.add(new ThrowAdvice());
//        adviceList.add(new ReturnAdvice());
//        adviceList.add(new AfterAdvice());
//        adviceList.add(new BeforeAdvice());
//        chain.proceed();


        UserService proxy = (UserService) new ProxyFactory2().getProxy(userService);
        proxy.insert("张三");



    }
}
