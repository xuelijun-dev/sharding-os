package com.greenbon.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.greenbon.base.page.PageDTO;

import java.util.List;
import java.util.Map;

/**
 * @author caolei
 */
public interface CommonService<T> extends IService<T> {

    /**
     * 数据分页查询接口
     * @param dto
     * @return
     */
    Object queryPage(PageDTO dto);

    /**
     * 数据列表查询接口
     * @param filter
     * @return
     */
    List<Map<String, Object>> queryList(Map<String, Object> filter);


}
