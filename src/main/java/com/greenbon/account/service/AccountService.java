package com.greenbon.account.service;


import com.greenbon.account.domain.Account;
import com.greenbon.base.service.CommonService;

import java.util.List;


public interface AccountService extends CommonService<Account> {


    boolean add(Account account);

    boolean edit(Account account);

    boolean delete(List<Long> ids);

    Account findById(Long id);
}
