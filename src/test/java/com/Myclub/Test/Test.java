package com.Myclub.Test;

import com.Myclud.Dao.IAccountDao;
import com.Myclud.Dao.impl.AccountDaoImpl;
import com.Myclud.Domain.Account;
import com.Myclud.Service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Test {
    Account account = new Account();
    IAccountService as;

    @Before
    public void init(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        as = ac.getBean("accountService",IAccountService.class);
    }

    @org.junit.Test
    public void testFiandAll() {
        List<Account> a = as.findAllAccount();
        for(Account x : a){
            System.out.println(x);
        }
    }

    @org.junit.Test
    public void testFindById(){
        Account a = as.findAccountById(3);
        System.out.println(a);
    }

    @org.junit.Test
    public void testSave(){
        account.setName("ddd");
        account.setMoney((float) 20.0);
        as.saveAccount(account);
    }

    @org.junit.Test
    public void testUpdate(){
        account.setId(2);
        account.setName("ddd");
        account.setMoney((float) 20.0);
        as.updateAccount(account);
    }

    @org.junit.Test
    public void testDelete(){
        as.deleteAccount(2);
    }
}
