package com.greenbon.account.service;


import com.greenbon.account.domain.AccountAssociate;
import com.greenbon.base.service.CommonService;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AccountAssociateService extends CommonService<AccountAssociate> {


    boolean add(AccountAssociate associate);

    boolean edit(AccountAssociate associate);

    boolean delete(List<Long> ids);

    AccountAssociate findById(Long id);


    List<AccountAssociate> findByAccountId(Long accountId);
}
