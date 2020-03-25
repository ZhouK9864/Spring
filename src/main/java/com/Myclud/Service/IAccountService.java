package com.Myclud.Service;

import com.Myclud.Domain.Account;

import javax.annotation.Resource;
import java.util.List;

public interface IAccountService {
    /*
     *模拟保存
     */
//    void saveAccount();
        /*
        * 查询所有
        */
    List<Account> findAllAccount();

    /*
     * 根据id查询一个
     */
    Account findAccountById(Integer accountId);

    /*
     * 保存
     */
    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

}
