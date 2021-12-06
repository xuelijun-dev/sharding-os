package com.greenbon.account.dao;

import com.greenbon.account.domain.AccountAssociate;
import com.greenbon.account.domain.support.vo.InitAccountPageVo;
import com.greenbon.base.dao.CommonDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caolei
 * @since 2020-09-11
 */
@Mapper
public interface AccountAssociateDao extends CommonDao<AccountAssociate> {
    /**
     * 查询分页数据
     * @param initAccountVo
     * @return
     */
    List<AccountAssociate> listByPage(@Param("initAccountVo") InitAccountPageVo initAccountVo);

    /**
     * 查询分页数据
     * @param initAccountVo
     * @return
     */
    List<AccountAssociate> listNoAvatarHashByPage(@Param("initAccountVo") InitAccountPageVo initAccountVo);
    /**
     * 查询没有头像hash值的数据量
     * @return
     */
    int countNoAvatarHash();


    AccountAssociate findById(@Param("id") Long id);


    List<AccountAssociate> findByAccountId(@Param("accountId") Long accountId);

}
