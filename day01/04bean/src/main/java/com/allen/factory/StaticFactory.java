package com.allen.factory;

import com.allen.service.IAccountService;
import com.allen.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类
 */
public class StaticFactory {
    public static IAccountService getAccountService(){
        return  new AccountServiceImpl();
    }
}
