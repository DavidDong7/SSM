package com.neusoft.service.Impl;

import com.neusoft.dao.IAccountDao;
import com.neusoft.domain.Account;
import com.neusoft.service.AccountService;
import com.neusoft.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll()
    {
        System.out.println("业务层所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account)
    {
        System.out.println("业务层添加账户");
        accountDao.saveAccount(account);
    }
}
