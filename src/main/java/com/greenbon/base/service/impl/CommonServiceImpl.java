package com.greenbon.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenbon.base.dao.CommonDao;
import com.greenbon.base.page.PageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Transactional(rollbackFor = Exception.class)
public class CommonServiceImpl<M extends CommonDao<T>, T> extends ServiceImpl<M, T> {
    @Autowired
    public M dao;

    /**
     * 数据分页查询接口
     * @param dto
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Object queryPage(PageDTO dto) {
        return dao.queryPage(PageDTO.coverPage(dto), dto.getCondition());
    }

    /**
     * 数据列表查询接口
     * @param filter
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String, Object>> queryList(Map<String, Object> filter) {
        return dao.queryList(filter);
    }

}
