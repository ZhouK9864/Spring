package com.Myclud.Factory;

import com.Myclud.Service.impl.AccountServiceImpl;

public class instanceFactory {

    public AccountServiceImpl getIAccountService() {
        return new AccountServiceImpl();
    }
}
