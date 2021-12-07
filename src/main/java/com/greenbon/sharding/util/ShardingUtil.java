package com.greenbon.sharding.util;


import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * 分库分表工具类
 * @author xlj
 * @date 2021-09-10
 */
@Slf4j
public class ShardingUtil {

    /**
     * 获取年月字符串
     * @param date 时间
     * @return 年月字符串
     */
    public static String getYearMonthTableSuffixByDate(Date date) {
        return DateUtils.getDate(date,"yyyyMM");
    }

    /**
     * 根据时间范围获取年月字符串列表
     * @param lowerDate 时间限下
     * @param upperDate 时间上限
     * @return 年月字符串列表
     */
    public static Set<String> getYearMonthTableSuffixListByRange(Date lowerDate, Date upperDate) {
        String lowerTableSuffix = getYearMonthTableSuffixByDate(lowerDate);
        String upperTableSuffix = getYearMonthTableSuffixByDate(upperDate);
        Set<String> suffixList = new TreeSet<>();
        if (lowerTableSuffix.equals(upperTableSuffix)) {
            //时间上下界限相同
            suffixList.add(lowerTableSuffix);
        } else {
            //时间上下界限不相同,计算间隔的所有表
            String tempSuffix = lowerTableSuffix;
            suffixList.add(tempSuffix);
            while (!tempSuffix.equals(upperTableSuffix)) {
                String year = tempSuffix.substring(0, 4);
                String month = tempSuffix.substring(4, tempSuffix.length());
                Date tempDate = DateUtils.getDate(year + (month.length() == 1 ? "0" + month : month), "yyyyMM");
                Date realDate = DateUtils.goMonth(tempDate, 1);
                tempSuffix = getYearMonthTableSuffixByDate(realDate);
                suffixList.add(tempSuffix);
            }
        }
        return suffixList;
    }

    /**
     * 判断年月字符串列表是否包含查询表名
     * @param yearMonthSuffixList 年月字符串列表
     * @param tableName 查询表名
     * @return boolean 包含返回true
     */
    public static boolean isContainTableName(Set<String> yearMonthSuffixList, String tableName) {
        boolean flag = false;
        for (String yearMonthSuffix : yearMonthSuffixList) {
            if (tableName.endsWith(yearMonthSuffix)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 检查分片键值类型，并转换为Date类型
     *
     * @param ShardingValue 分片键值
     * @return Date 分片键值
     */
    public static Date transferShardingValue(Object ShardingValue) {
        Date date;
        if (ShardingValue instanceof String) {
            log.info("########## (sharding-jdbc分表) 分片键值类型为String转化为Date ##########");
            date = DateUtils.getDateTime((String) ShardingValue);
        } else {
            log.info("########## (sharding-jdbc分表) 分片键值类型为Date ##########");
            date = (Date) ShardingValue;
        }
        return date;
    }

    public static void main(String[] args) {
        String s = "202101";
        String year = s.substring(0, 4);
        String month = s.substring(4,s.length());
        System.out.println(year);
        System.out.println(month);
    }


}
