package com.greenbon.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.greenbon.account.dao.AccountAssociateDao;
import com.greenbon.account.domain.AccountAssociate;
import com.greenbon.account.service.AccountAssociateService;
import com.greenbon.base.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author caolei
 * @since 2020-09-11
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class AccountAssociateServiceImpl extends CommonServiceImpl<AccountAssociateDao, AccountAssociate> implements AccountAssociateService {

    @Override
    public boolean add(AccountAssociate associate) {
        return this.save(associate);
    }

    @Override
    public boolean edit(AccountAssociate associate) {
        return this.updateById(associate);
    }

    @Override
    public boolean delete(List<Long> ids) {
        UpdateWrapper<AccountAssociate> updateWrapper = new UpdateWrapper();
        updateWrapper.lambda().set(AccountAssociate::getStatus,-1);
        updateWrapper.lambda().in(AccountAssociate::getId,ids);
        return this.update(updateWrapper);
    }

    @Override
    public AccountAssociate findById(Long id) {
        return this.getById(id);
    }
}
