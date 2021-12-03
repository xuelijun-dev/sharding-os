package com.greenbon.base.comm;


import org.apache.commons.collections.map.HashedMap;

/**
 * @author open_developer
 * 全局map转换接口,将下划线转换成驼峰
 */
public class ResultMap extends HashedMap {
    @Override
    public Object put(Object key, Object value) {
        return super.put(StringUtils.underlineToHump(String.valueOf(key)), value);
    }
}
