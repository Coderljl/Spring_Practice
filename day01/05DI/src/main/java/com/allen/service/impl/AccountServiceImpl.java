package com.allen.service.impl;


import com.allen.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //如果是经常变化的值，并不适合使用注入
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccout() {
        System.out.println("service中的saveAccout方法执行");
        System.out.println("name:"+name+";age:"+age+";birthday:"+birthday+";");
    }
}
