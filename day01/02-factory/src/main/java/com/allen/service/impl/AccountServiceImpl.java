package com.allen.service.impl;

import com.allen.dao.IAccountDao;
import com.allen.dao.impl.AccountDaoImpl;
import com.allen.factory.BeanFactory;
import com.allen.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao iAccountDao=new AccountDaoImpl();
    private IAccountDao iAccountDao= (IAccountDao) BeanFactory.getBean("accountDao");

    public AccountServiceImpl() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    }
    private int i =1;

    public void saveAccout() {
        iAccountDao.saveAccout();
        System.out.println(i);
        i++;
    }
}
