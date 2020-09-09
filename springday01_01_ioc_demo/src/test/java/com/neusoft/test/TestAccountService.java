package com.neusoft.test;

import com.neusoft.domain.Account;
import com.neusoft.service.IAccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAccountService {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    IAccountService as = ac.getBean("accountServiceImpl", IAccountService.class);

    @Test
    public void testFindAll(){

        List<Account> allAccount = as.findAllAccount();
        for (Account account:allAccount){
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById(){
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(12345f);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        Account account = as.findAccountById(4);
        account.setMoney(234f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        as.deleteAccount(4);
    }
}
