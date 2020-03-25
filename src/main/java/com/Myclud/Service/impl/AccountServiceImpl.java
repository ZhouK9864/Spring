package com.Myclud.Service.impl;

import com.Myclud.Dao.IAccountDao;
import com.Myclud.Dao.impl.AccountDaoImpl;
import com.Myclud.Domain.Account;
import com.Myclud.Service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/*
 *业务层实现类
 * @Value 用于注入基本类型和String表达式 使用el表达式 ${表达式}
 * @Scope 用于指定bean的作用范围
 */
//@Service(value = "accountService")
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Resource
    private IAccountDao accountDao;


    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);

    }
//    @Resource(name = "accountDao2")
//    private IAccountDao accountDao;
//
//    public AccountServiceImpl(){
//        System.out.println("我是构造函数");
//    }
//
//    public void saveAccount(){
//        accountDao.saveAccount();
//        System.out.println("我证明我保存好了！");
//    }
//    public void init(){
//        System.out.println("我开始啦！");
//    }
//
//    public void destory(){
//        System.out.println("我结束啦！");
//    }


}

