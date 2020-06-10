package com.allen.service.impl;


import com.allen.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }



    public void saveAccout() {
        System.out.println("service中的saveAccout方法执行");
    }

    public void  init(){
        System.out.println("对象初始化了。。。");
    }
    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }

}
