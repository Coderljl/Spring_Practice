package com.allen.dao.impl;

import com.allen.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    @Autowired
    public IAccountDao accountDao1;
    public void saveAccout() {
        System.out.println("保存账户22222");
    }
}
