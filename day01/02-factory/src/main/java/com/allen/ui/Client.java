package com.allen.ui;

import com.allen.factory.BeanFactory;
import com.allen.service.IAccountService;
import com.allen.service.impl.AccountServiceImpl;

import static com.allen.factory.BeanFactory.getBean;

public class Client {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) getBean("accountService");
            System.out.println(as);
            as.saveAccout();
        }
    }
}
