package com.allen.service.impl;

import com.allen.dao.IAccountDao;
import com.allen.dao.impl.AccountDaoImpl;
import com.allen.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao=new AccountDaoImpl();
    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }



    public void saveAccout() {
        iAccountDao.saveAccout();
    }
}
