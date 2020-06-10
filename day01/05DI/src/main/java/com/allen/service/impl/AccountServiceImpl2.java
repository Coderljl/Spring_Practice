package com.allen.service.impl;


import com.allen.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {
    //如果是经常变化的值，并不适合使用注入
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccout() {
        System.out.println("service中的saveAccout方法执行");
        System.out.println("name:"+name+";age:"+age+";birthday:"+birthday+";");
    }
}
