package com.allen.service.impl;

import com.allen.dao.IAccountDao;
import com.allen.domain.Account;
import com.allen.service.IAccountService;
import com.allen.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService{
    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private TransactionManager txManenge;

    public void setTxManenge(TransactionManager txManenge) {
        this.txManenge = txManenge;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            txManenge.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManenge.commit();
            //4.返回结果
            return accounts ;
        }catch (Exception e){
            //5.回滚操作
            txManenge.rollback();
            System.out.println(e);
            throw  new RuntimeException(e);
        }finally {
            //6.释放资源
            txManenge.release();

        }

    }


    public Account findAccountById(Integer accountId) {
        try{
            //1.开启事务
            txManenge.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(accountId);
            //3.提交事务
            txManenge.commit();
            //4.返回结果
            return account;
        }catch (Exception e){
            //5.回滚操作
            txManenge.rollback();
            System.out.println(e);
            throw  new RuntimeException(e);
        }finally {
            //6.释放资源
            txManenge.release();
        }

    }


    public void saveAccount(Account account) {
        try{
            //1.开启事务
            txManenge.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManenge.commit();

        }catch (Exception e){
            //5.回滚操作
            txManenge.rollback();
            System.out.println(e);
        }finally {
            //6.释放资源
            txManenge.release();
        }

    }


    public void updateAccount(Account account) {
        try{
            //1.开启事务
            txManenge.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManenge.commit();

        }catch (Exception e){
            //5.回滚操作
            txManenge.rollback();
            System.out.println(e);
        }finally {
            //6.释放资源
            txManenge.release();

        }

    }


    public void deleteAccount(Integer acccountId) {
        try{
            //1.开启事务
            txManenge.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(acccountId);
            //3.提交事务
            txManenge.commit();

        }catch (Exception e){
            //5.回滚操作
            txManenge.rollback();
            System.out.println(e);
        }finally {
            //6.释放资源
            txManenge.release();
        }

    }

    public void transfer(String sourceName, String targetName, Float money) {
        try{
            //1.开启事务
            txManenge.beginTransaction();
            //2.执行操作
            System.out.println("transfer....");
            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(source);

//            int i=1/0;

            //2.6更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManenge.commit();

        }catch (Exception e){
            //5.回滚操作
            txManenge.rollback();
            System.out.println(e);
        }finally {
            //6.释放资源
            txManenge.release();
        }

    }
}
