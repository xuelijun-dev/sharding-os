package com.greenbon.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.greenbon.account.dao.AccountDao;
import com.greenbon.account.domain.Account;
import com.greenbon.account.service.AccountService;
import com.greenbon.base.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl extends CommonServiceImpl<AccountDao, Account> implements AccountService {

    @Override
    public boolean add(Account account) {
        return this.save(account);
    }

    @Override
    public boolean edit(Account account) {
        return this.updateById(account);
    }

    @Override
    public boolean delete(List<Long> ids) {
        UpdateWrapper<Account> updateWrapper = new UpdateWrapper();
        updateWrapper.lambda().set(Account::getStatus,-1);
        updateWrapper.lambda().in(Account::getId,ids);
        return this.update(updateWrapper);
    }

    @Override
    public Account findById(Long id) {
        return dao.findById(id);
    }
}
