package com.greenbon.account.dao;

import com.greenbon.account.domain.Account;
import com.greenbon.base.dao.CommonDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface AccountDao extends CommonDao<Account> {
    Account findById(@Param("id") Long id);

}
