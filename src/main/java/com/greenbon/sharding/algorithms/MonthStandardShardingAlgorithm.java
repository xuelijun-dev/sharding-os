//package com.greenbon.sharding.algorithms;
//
//import com.alibaba.druid.support.json.JSONUtils;
//import com.google.common.collect.Range;
//import com.greenbon.sharding.util.ShardingUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.Set;
//import java.util.TreeSet;
//
//@Slf4j
//@Component
//public class MonthStandardShardingAlgorithm implements StandardShardingAlgorithm<Date> {
//    @Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> preciseShardingValue) {
//        log.info("############### (sharding-jdbc分表) PreciseShardingAlgorithm     collection:{} ###############", JSONUtils.toJSONString(availableTargetNames));
//        log.info("############### (sharding-jdbc分表) PreciseShardingAlgorithm     preciseShardingValue:{} ###############", preciseShardingValue);
//        Date createTime = ShardingUtil.transferShardingValue(preciseShardingValue.getValue());
//        //表名尾缀 如：YYYY_M
//        String yearMonthTableSuffix = ShardingUtil.getYearMonthTableSuffixByDate(createTime);
//        log.info("############### (sharding-jdbc分表) PreciseShardingAlgorithm yearMonthTableSuffix:{} ###############", yearMonthTableSuffix);
//        //开启异步线程去检查真实表,不存在则创建
//        for (String tableName : availableTargetNames) {
//            if (tableName.endsWith(yearMonthTableSuffix)) {
//                log.info("############### (sharding-jdbc分表) PreciseShardingAlgorithm 最终匹配表名:{} ###############", tableName);
//                return tableName;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> rangeShardingValue) {
//        log.info("############### (sharding-jdbc分表) RangeShardingAlgorithm     collection:{} ###############", JSONUtils.toJSONString(availableTargetNames));
//        log.info("############### (sharding-jdbc分表) RangeShardingAlgorithm     rangeShardingValue:{} ###############", rangeShardingValue);
//        Set<String> tableNames = new TreeSet<>();
//        Range<Date> createTimeRange = rangeShardingValue.getValueRange();
//        Date lowerDate = ShardingUtil.transferShardingValue(createTimeRange.lowerEndpoint());
//        Date upperDate = ShardingUtil.transferShardingValue(createTimeRange.upperEndpoint());
//        //根据时间范围获取年月字符串列表
//        Set<String> yearMonthSuffixList = ShardingUtil.getYearMonthTableSuffixListByRange(lowerDate, upperDate);
//        log.info("############### (sharding-jdbc分表) RangeShardingAlgorithm yearMonthSuffixList:{} ###############", JSONUtils.toJSONString(yearMonthSuffixList));
//        for (String tableName : availableTargetNames) {
//            if (ShardingUtil.isContainTableName(yearMonthSuffixList, tableName)) {
//                tableNames.add(tableName);
//            }
//        }
//        log.info("############### (sharding-jdbc分表) RangeShardingAlgorithm 最终匹配表名:{} ###############", JSONUtils.toJSONString(tableNames));
//        return tableNames;
//    }
//
//    @Override
//    public void init() {
//
//    }
//
//    @Override
//    public String getType() {
//        return "monthShardingAlgorithm";
//    }
//}
