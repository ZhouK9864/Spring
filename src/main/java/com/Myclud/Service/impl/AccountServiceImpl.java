package com.Myclud.Service.impl;

import com.Myclud.Dao.IAccountDao;
import com.Myclud.Dao.impl.AccountDaoImpl;
import com.Myclud.Service.IAccountService;
/*
 *业务层实现类
 */

public class AccountServiceImpl implements IAccountService {
//    IAccountDao accountDao = new AccountDaoImpl();
    public AccountServiceImpl(){
        System.out.println("我是构造函数");
    }
    public void saveAccount(){
//        accountDao.saveAccount();
        System.out.println("我创建好了！");
    }

    public void init(){
        System.out.println("我开始啦！");
    }

    public void destory(){
        System.out.println("我结束啦！");
    }

}
