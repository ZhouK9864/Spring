package com.Myclud.ui;
/*
 *模拟表现层 用来调用业务层
 */

import com.Myclud.Dao.IAccountDao;
import com.Myclud.Domain.Account;
import com.Myclud.Service.IAccountService;
import com.Myclud.Service.impl.AccountServiceImpl;
import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client {
    /*
     * 获取spring ioc核心容器，并根据id获取对象
     */
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = ac.getBean("accountService",IAccountService.class);
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        List<Account> a = as.findAllAccount();
        for(Account x : a){
            System.out.println(x);
        }
    }
}
