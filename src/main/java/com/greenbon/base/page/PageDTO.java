package com.greenbon.base.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author xbuding
 * @version 1.0
 * @since 2018/1/5
 */
@Getter
@Setter
public class PageDTO<T> implements Serializable {

    /**
     * 数量
     */
    private List<T> records;
    /**
     * sql 条件
     */
    private Map<String, Object> condition = new HashMap<>();
    /**
     * 开始页数
     */
    private int current = 0;
    /**
     * 每页的数据量
     */
    private int size = 10;

    /**
     * 用来计算起始的pageNum
     */
    private Integer startLimit;
    /**
     * 总数
     */
    private long total = 0;

    /**
     * 升序，多个字段逗号拼接
     */
    private String ascs;

    /**
     * 降序，多个字段逗号拼接
     */
    private String descs;

    /**
     * dto转换成mybatis-plus的分页参数
     *
     * @param dto
     * @return
     */
    public static Page coverPage(PageDTO dto) {
        if (!String.valueOf(dto.getCurrent()).equals("") ||
                !String.valueOf(dto.getSize()).equals("")) {
            return new Page(dto.getCurrent(), dto.getSize())
                    .addOrder(OrderItem.ascs(dto.getAscs()))
                    .addOrder(OrderItem.descs(dto.getDescs()));
        }
        return null;
    }
}
