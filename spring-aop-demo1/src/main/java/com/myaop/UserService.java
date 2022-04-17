package com.myaop;

public class UserService {

    public String insert(String name) {
        System.out.println("==插入操作成功，用户：" + name);
        int x = 1 / 1;
        return "插入成功";
    }
}
