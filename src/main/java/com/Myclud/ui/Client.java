package com.Myclud.ui;
/*
 *模拟表现层 用来调用业务层
 */

import com.Myclud.Dao.IAccountDao;
import com.Myclud.Service.IAccountService;
import com.Myclud.Service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    /*
     * 获取spring ioc核心容器，并根据id获取对象
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as = ac.getBean("accountService",IAccountService.class);
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        as.findAllAccount();
    }
}
