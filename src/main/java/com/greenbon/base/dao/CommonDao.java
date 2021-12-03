package com.greenbon.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * MyBatis 基础类接口，继承它的子类必须要和MyBatis Mapper文件同名，直接映射其实现方法
 * 实现主要接口如下： insert，insertBatch，update,updateMap,deleteByKey,delete,deleteBatch,fetch,count,list,page
 *
 * @author panjinfa
 */
public interface CommonDao<T> extends BaseMapper<T> {
    /**
     * 批量插入列表,请自行根据字段调整批量插入长度，一般情况下，不能超过500条
     * 按实际表的字段大小进行调整，
     *
     * @param list
     * @return
     */

    Integer insertList(List<T> list);

    /**
     * 查询后台表格分页数据
     *
     * @param page
     * @param filter
     * @return
     */
    IPage<Map<String, Object>> queryPage(@Param("page") Page page, @Param("filter") Map<String, Object> filter);


    /**
     * 普通列表查询接口，不分页
     *
     * @param filter:
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     */
    List<Map<String, Object>> queryList(@Param("filter") Map<String, Object> filter);
}
