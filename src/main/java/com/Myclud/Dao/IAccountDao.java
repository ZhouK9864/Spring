package com.Myclud.Dao;
/*
 * 账户的持久层接口
 */

import com.Myclud.Domain.Account;

import java.util.List;

public interface IAccountDao {
    //    void saveAccount();


    List<Account> findAllAccount();

    /**
     * 根据id查询一个
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     */
    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
    /**
     * 根据名称查询账户
     */
    Account finaAccountByName(String accountName);

}
