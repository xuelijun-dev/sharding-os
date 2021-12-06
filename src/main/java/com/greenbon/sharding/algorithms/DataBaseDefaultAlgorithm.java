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
//import java.util.*;
//
//@Slf4j
//@Component
//public class DataBaseDefaultAlgorithm implements StandardShardingAlgorithm<Integer> {
//    @Override
//    public String doSharding(Collection<String> databaseNames, PreciseShardingValue<Integer> preciseShardingValue) {
//        log.info("############### (sharding-jdbc分表) PreciseShardingAlgorithm     collection:{} ###############", JSONUtils.toJSONString(databaseNames));
//        log.info("############### (sharding-jdbc分表) PreciseShardingAlgorithm     preciseShardingValue:{} ###############", preciseShardingValue);
//        for (String each : databaseNames) {
//            if (each.endsWith(String.valueOf(preciseShardingValue.getValue() % 2))) {
//                return each;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Collection<String> doSharding(Collection<String> databaseNames, RangeShardingValue<Integer> rangeShardingValue) {
//        Set<String> result = new LinkedHashSet<>();
//        if (Range.closed(1, 5).encloses(rangeShardingValue.getValueRange())) {
//            for (String each : databaseNames) {
//                if (each.endsWith("0")) {
//                    result.add(each);
//                }
//            }
//        } else if (Range.closed(6, 10).encloses(rangeShardingValue.getValueRange())) {
//            for (String each : databaseNames) {
//                if (each.endsWith("1")) {
//                    result.add(each);
//                }
//            }
//        } else if (Range.closed(1, 10).encloses(rangeShardingValue.getValueRange())) {
//            result.addAll(databaseNames);
//        } else {
//            throw new UnsupportedOperationException("");
//        }
//        return result;
//    }
//
//    @Override
//    public void init() {
//
//    }
//
//    @Override
//    public String getType() {
//        return "dataBaseDefaultAlgorithm";
//    }
//}
