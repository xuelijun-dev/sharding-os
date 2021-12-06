package com.greenbon.sharding.util;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 *
 * @author open_developer
 */
public class DateUtils {

    /**
     * 年月日格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 年月日格式（斜线）
     */
    public static final String DATE_SPLITE_FORMAT = "yyyy/MM/dd";

    /**
     * 年月日格式(斜线)
     */
    public static final String DATETIME_SPLITE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    /**
     * 按坚线分隔
     */
    public static final String DATETIME_WITH_LINE_FORMAT = "yyyy-MM-dd|HH:mm:ss";

    /**
     * 年月日格式（16位长度斜线）
     */
    public static final String DATE_MID_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * 年月日格式（16位长度斜线）
     */
    public static final String DATE_MID_FORMAT_BY_HOURS = "yyyy-MM-dd HH";

    /**
     * 年月日格式(16位长度斜线)
     */
    public static final String DATE_SPLITE_MID_FORMAT = "yyyy/MM/dd HH:mm";

    /**
     * 中国文字的 年月日
     */
    public static final String DATE_CHINESE_FORMATE = "yyyy年MM月dd日";

    /**
     * 年月日时分秒格式
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时分秒格式
     */
    public static final String TIME_FORMAT = "HH:mm";

    /**
     * 中国文字的 年月日
     */
    public static final String DATETIME_CHINESE_FORMATE = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 年月日时分秒简单格式
     */
    public static final String DATETIME_SIMPLE_FORMATE = "yyyyMMddHHmmss";
//
//    /**
//     * 获取阳历
//     *
//     * @param lunar 农历，格式yyyy-MM-dd
//     * @return
//     */
//    public static String getSolar(String lunar) {
//        return getLunarBeanByLunar(lunar).getSolar();
//    }

//    /**
//     * 获取农阳历对象
//     *
//     * @param lunar 农历，格式yyyy-MM-dd
//     * @return
//     */
//    public static Lunar getLunarBeanByLunar(String lunar) {
//        return Lunar.create(lunar, false);
//    }

//    /**
//     * 获取农历
//     *
//     * @param solar  阳历，格式yyyy-MM-dd
//     * @param format 格式化：<br/>
//     *               #gz#：干支<br/>
//     *               #sx#：生肖<br/>
//     *               #m#：月<br/>
//     *               #d#：日<br/>
//     * @return
//     */
//    public static String getLunar(String solar, String format) {
//        Lunar lunar = getLunarBeanBySolar(solar);
//
//        format = format.replaceAll("#gz#", lunar.getLunarYearName());
//        format = format.replaceAll("#sx#", lunar.getLunarAnimal());
//        format = format.replaceAll("#m#", lunar.getLunarMonth());
//        format = format.replaceAll("#d#", lunar.getLunarDay());
//
//        return format;
//    }
//
//    /**
//     * 获取农历
//     *
//     * @param solar 阳历，格式yyyy-MM-dd
//     * @return
//     */
//    public static String getLunar(String solar) {
//        return getLunarBeanBySolar(solar).getLunar();
//    }

//    /**
//     * 获取农阳历对象
//     *
//     * @param solar 阳历，格式yyyy-MM-dd
//     * @return
//     */
//    public static Lunar getLunarBeanBySolar(String solar) {
//        return Lunar.create(solar, true);
//    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public static Long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取指定时间时间戳
     *
     * @return
     */
    public static Long getTimestamp(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public static Long getSecondTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取日期解析
     *
     * @param format 格式
     * @return
     */
    public static DateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 获取当前系统日期，包含时分秒
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取今天日期，时分秒都为零
     *
     * @return
     */
    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取日历对象
     *
     * @return
     */
    public static Date getCurrentDateNoTime() {
        Calendar calendar = getCalendar(getCurrentDate());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取日历对象
     *
     * @param date
     * @return
     */
    public static Date getDateNoTime(Date date) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取日期字符串
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return
     */
    public static String getDateStr(int year, int month, int day) {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    /**
     * 获取日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return
     */
    public static Date getDate(int year, int month, int day) {
        return getDate(getDateStr(year, month, day));
    }

    /**
     * 获取日期
     *
     * @param date 日期，格式：yyyy-MM-dd
     * @return
     */
    public static Date getDate(String date) {
        return getDate(date, DATE_FORMAT);
    }

    /**
     * 获取日期
     *
     * @param date 日期，格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getDateTime(String date) {
        return getDate(date, DATETIME_FORMAT);
    }

    /**
     * 获取日期
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static Date getDate(String date, String format) {
        try {
            return getFormat(format).parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取日期字符串
     *
     * @param date 日期，格式：yyyy-MM-dd
     * @return
     */
    public static String getDate(Date date) {
        return getDate(date, DATE_FORMAT);
    }


    /**
     * 获取日期字符串
     *
     * @param date 日期，格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateTime(Date date) {
        return getDate(date, DATETIME_FORMAT);
    }


    public static void main(String[] args) {
        Date date1 = DateUtils.getCurrentDate();
        Date date = DateUtils.getDateEndTime(DateUtils.goDay(new Date(), -1));
        System.out.println(date);
        System.out.println(date1);

    }

    /**
     * 获取日期字符串
     *
     * @param date   日期
     * @param format 格式
     * @return
     */
    public static String getDate(Date date, String format) {
        try {
            return getFormat(format).format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取当前天的开始时间
     *
     * @return
     */
    public static String getStartTime() {
        return DateUtils.getStartTime(DateUtils.getCurrentDate());
    }


    /**
     * 获取指定天的开始时间
     *
     * @return
     */
    public static String getStartTime(Date date) {
        return DateUtils.getDate(date, DATE_FORMAT) + " 00:00:00";
    }

    /**
     * 获取指定天的开始时间
     *
     * @return
     */
    public static Date getDateStartTime(Date date) {
        return DateUtils.getDateTime(getStartTime(date));
    }


    /**
     * 获取当天的结束时间
     *
     * @return
     */
    public static String getEndTime() {
        return getEndTime(DateUtils.getCurrentDate());
    }

    /**
     * 获取指定天的结束时间
     *
     * @param date
     * @return
     */
    public static String getEndTime(Date date) {
        return DateUtils.getDate(date, DATE_FORMAT) + " 23:59:59";
    }

    /**
     * 获取指定天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getDateEndTime(Date date) {
        return DateUtils.getDateTime(getEndTime(date));
    }


    /**
     * 获取当前天的开始时间
     *
     * @return
     */
    public static String getHourStartTime(Date date) {
        return DateUtils.getDate(date, DATE_MID_FORMAT_BY_HOURS) + ":00:00";
    }

    public static String getHourEndTime(Date date) {
        return DateUtils.getDate(date, DATE_MID_FORMAT_BY_HOURS) + ":59:59";
    }

    /**
     * 获取日历对象
     *
     * @param date
     * @return
     */
    public static Calendar getCalendar(String date) {
        Calendar calendar = Calendar.getInstance();

        if (date.contains(":")) {
            calendar.setTime(getDateTime(date));
        } else {
            calendar.setTime(getDate(date));
        }

        return calendar;
    }

    /**
     * 获取日历对象
     *
     * @param date
     * @return
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    /**
     * getRfc1123格式日期
     *
     * @return
     */
    public static String getRfc1123Time() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 天数差，第一个日期 - 第二个日期
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return
     */
    public static int daysBetween(Date firstDate, Date secondDate) {
        Calendar f = getCalendar(firstDate);
        Calendar s = getCalendar(secondDate);
        f.set(Calendar.HOUR_OF_DAY, 0);
        f.set(Calendar.MINUTE, 0);
        f.set(Calendar.SECOND, 0);
        s.set(Calendar.HOUR_OF_DAY, 0);
        s.set(Calendar.MINUTE, 0);
        s.set(Calendar.SECOND, 0);

        return ((int) (s.getTime().getTime() / 1000) - (int) (f.getTime().getTime() / 1000)) / 3600 / 24;
    }

    /**
     * 两个日期的分钟差
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static int minuteBetween(Date firstDate, Date secondDate) {
        Calendar f = getCalendar(firstDate);
        Calendar s = getCalendar(secondDate);
        return ((int) (s.getTime().getTime() / 1000) - (int) (f.getTime().getTime() / 1000)) / 60;
    }

    /**
     * 两个日期的秒差
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static int secondBetween(Date firstDate, Date secondDate) {


        return (int) (firstDate.getTime() - secondDate.getTime()) / 1000;
    }

    /**
     * 获取两个日期相差年数
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static int yearsBetween(Date firstDate, Date secondDate) {
        Calendar f = getCalendar(firstDate);
        Calendar s = getCalendar(secondDate);
        return Math.abs(f.get(Calendar.YEAR) - s.get(Calendar.YEAR));
    }

    /**
     * 第一个日期是否早于第二个日期
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return
     */
    public static boolean isBefore(Date firstDate, Date secondDate) {
        return compareDate(firstDate, secondDate) == -1;
    }

    /**
     * 第一个日期是否晚于第二个日期
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return
     */
    public static boolean isAfter(Date firstDate, Date secondDate) {
        return compareDate(firstDate, secondDate) == 1;
    }

    /**
     * 第一个日期是否等于第二个日期
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return
     */
    public static boolean isEqual(Date firstDate, Date secondDate) {
        return compareDate(firstDate, secondDate) == 0;
    }

    /**
     * 比较两个时间点
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return firstDate == secondDate，返回 0 <br/>
     * firstDate < secondDate，返回 -1 <br/>
     * firstDate > secondDate，返回 1 <br/>
     */
    public static int compareDate(Date firstDate, Date secondDate) {
        return getCalendar(firstDate).compareTo(getCalendar(secondDate));
    }

    /**
     * 比较日期是否在起期和止期之间
     *
     * @param compareDate 比较日期
     * @param startDate   起期
     * @param endDate     止期
     * @return
     */
    public static boolean between(Date compareDate, Date startDate, Date endDate) {
        return !isAfter(startDate, compareDate) && !isBefore(endDate, compareDate);
    }

    /**
     * 返回年份
     *
     * @param date 日期
     * @return
     */
    public static int getYear(Date date) {
        return getYear(getCalendar(date));
    }

    /**
     * 返回年份
     *
     * @param calendar 日历
     * @return
     */
    public static int getYear(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回当前日期是当年的第几周
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static int getWeek(Date date) {
        return getCalendar(date).get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * 返回月份
     *
     * @param date 日期
     * @return
     */
    public static int getMonth(Date date) {
        return getMonth(getCalendar(date));
    }

    /**
     * 返回月份
     *
     * @param calendar 日历
     * @return
     */
    public static int getMonth(Calendar calendar) {
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日份
     *
     * @param date 日期
     * @return
     */
    public static int getDay(Date date) {
        return getDay(getCalendar(date));
    }

    /**
     * 返回日份
     *
     * @param calendar 日历
     * @return
     */
    public static int getDay(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回小时
     *
     * @param date 日期
     * @return
     */
    public static int getHour(Date date) {
        return getHour(getCalendar(date));
    }

    /**
     * 返回小时
     *
     * @param calendar 日历
     * @return
     */
    public static int getHour(Calendar calendar) {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     *
     * @param date 日期
     * @return
     */
    public static int getMinute(Date date) {
        return getMinute(getCalendar(date));
    }

    /**
     * 返回分钟
     *
     * @param calendar 日历
     * @return
     */
    public static int getMinute(Calendar calendar) {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date 日期
     * @return
     */
    public static int getSecond(Date date) {
        return getSecond(getCalendar(date));
    }

    /**
     * 返回秒钟
     *
     * @param calendar 日历
     * @return
     */
    public static int getSecond(Calendar calendar) {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取当周第一天日期
     *
     * @param date 参考日期
     * @return
     */
    public static Date getWeekBegin(Date date) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 获取当周最后一天日期
     *
     * @param date 参考日期
     * @return
     */
    public static Date getWeekEnd(Date date) {
        Calendar calendar = getCalendar(getWeekBegin(date));
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        return calendar.getTime();
    }

    /**
     * 获取当月第一天日期
     *
     * @param date 参考日期
     * @return
     */
    public static Date getMonthBegin(Date date) {
        Calendar calendar = getCalendar(date);
        return getMonthBegin(getYear(calendar), getMonth(calendar));
    }

    /**
     * 获取指定月第一天日期
     *
     * @param year  年
     * @param month 月
     * @return
     */
    public static Date getMonthBegin(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当月最后一天日期
     *
     * @param date 参考日期
     * @return
     */
    public static Date getMonthEnd(Date date) {
        Calendar calendar = getCalendar(date);
        return getMonthEnd(getYear(calendar), getMonth(calendar));
    }

    /**
     * 获取指定月最后一天日期
     *
     * @param year  年
     * @param month 月
     * @return
     */
    public static Date getMonthEnd(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取日期所在季度
     *
     * @param date 参考日期
     * @return
     */
    public static int getQuarter(Date date) {
        return getMonth(date) / 3 + 1;
    }

    /**
     * 获取当季第一天
     *
     * @param date 参考日期
     * @return
     */
    public static Date getQuarterStart(Date date) {
        return getQuarterStart(getYear(date), getQuarter(date));
    }

    /**
     * 获取指定季度第一天
     *
     * @param year    年
     * @param quarter 季度
     * @return
     */
    public static Date getQuarterStart(int year, int quarter) {
        int month = 1 + 3 * (quarter - 1);
        return getMonthBegin(year, month);
    }

    /**
     * 获取当季最后一天日期
     *
     * @param date 参考日期
     * @return
     */
    public static Date getQuarterEnd(Date date) {
        return getQuarterEnd(getYear(date), getQuarter(date));
    }

    /**
     * 获取指定季度最后一天日期
     *
     * @param year    年
     * @param quarter 季度
     * @return
     */
    public static Date getQuarterEnd(int year, int quarter) {
        int month = 3 * quarter;
        return getMonthEnd(year, month);
    }

    /**
     * 日期跳转
     *
     * @param date   日期
     * @param field  日历字段，如Calendar.YEAR、Calendar.MONTH、Calendar.DAY_OF_YEAR
     * @param amount 时间量
     * @return
     */
    public static Date go(Date date, int field, int amount) {
        Calendar calendar = getCalendar(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 年份跳转
     *
     * @param date 日期
     * @param year 年数
     * @return
     */
    public static Date goYear(Date date, int year) {
        return go(date, Calendar.YEAR, year);
    }

    /**
     * 小时跳转
     *
     * @param date  日期
     * @param hours 小时数
     * @return
     */
    public static Date goHours(Date date, int hours) {
        return go(date, Calendar.HOUR_OF_DAY, hours);
    }

    /**
     * 分钟跳转
     *
     * @param date    日期
     * @param minutes 分钟数
     *
     *
     * @return
     */
    public static Date goMinutes(Date date, int minutes) {
        return go(date, Calendar.MINUTE, minutes);
    }

    /**
     * 月份跳转
     *
     * @param date  日期
     * @param month 月数
     * @return
     */
    public static Date goMonth(Date date, int month) {
        return go(date, Calendar.MONTH, month);
    }

    /**
     * 天跳转
     *
     * @param date 日期
     * @param day  天数
     * @return
     */
    public static Date goDay(Date date, int day) {
        return go(date, Calendar.DAY_OF_YEAR, day);
    }

    /**
     * 农历处理类
     *
     * @author hedongzhou
     */
    public static class Lunar {

        /**
         * 最小年份
         */
        public static int MIN_YEAR = 1891;

        /**
         * 最大年份
         */
        public static int MAX_YEAR = 2100;

        /**
         * 农历信息
         */
        public static int[][] LUNAR_INFO = {{0, 2, 9, 21936}, {6, 1, 30, 9656}, {0, 2, 17, 9584}, {0, 2, 6, 21168}, {5, 1, 26, 43344}, {0, 2, 13, 59728}, {0, 2, 2, 27296}, {3, 1, 22, 44368}, {0, 2, 10, 43856}, {8, 1, 31, 19304}, {0, 2, 19, 19168}, {0, 2, 8, 42352}, {5, 1, 29, 21096}, {0, 2, 16, 53856}, {0, 2, 4, 55632}, {4, 1, 25, 27304}, {0, 2, 13, 22176}, {0, 2, 2, 39632}, {2, 1, 22, 19176}, {0, 2, 10, 19168}, {6, 1, 30, 42200}, {0, 2, 18, 42192},
                {0, 2, 6, 53840}, {5, 1, 26, 54568}, {0, 2, 14, 46400}, {0, 2, 3, 54944}, {2, 1, 23, 38608}, {0, 2, 11, 38320}, {7, 2, 1, 18872}, {0, 2, 20, 18800}, {0, 2, 8, 42160}, {5, 1, 28, 45656}, {0, 2, 16, 27216}, {0, 2, 5, 27968}, {4, 1, 24, 44456}, {0, 2, 13, 11104}, {0, 2, 2, 38256}, {2, 1, 23, 18808}, {0, 2, 10, 18800}, {6, 1, 30, 25776}, {0, 2, 17, 54432}, {0, 2, 6, 59984}, {5, 1, 26, 27976}, {0, 2, 14, 23248}, {0, 2, 4, 11104},
                {3, 1, 24, 37744}, {0, 2, 11, 37600}, {7, 1, 31, 51560}, {0, 2, 19, 51536}, {0, 2, 8, 54432}, {6, 1, 27, 55888}, {0, 2, 15, 46416}, {0, 2, 5, 22176}, {4, 1, 25, 43736}, {0, 2, 13, 9680}, {0, 2, 2, 37584}, {2, 1, 22, 51544}, {0, 2, 10, 43344}, {7, 1, 29, 46248}, {0, 2, 17, 27808}, {0, 2, 6, 46416}, {5, 1, 27, 21928}, {0, 2, 14, 19872}, {0, 2, 3, 42416}, {3, 1, 24, 21176}, {0, 2, 12, 21168}, {8, 1, 31, 43344}, {0, 2, 18, 59728},
                {0, 2, 8, 27296}, {6, 1, 28, 44368}, {0, 2, 15, 43856}, {0, 2, 5, 19296}, {4, 1, 25, 42352}, {0, 2, 13, 42352}, {0, 2, 2, 21088}, {3, 1, 21, 59696}, {0, 2, 9, 55632}, {7, 1, 30, 23208}, {0, 2, 17, 22176}, {0, 2, 6, 38608}, {5, 1, 27, 19176}, {0, 2, 15, 19152}, {0, 2, 3, 42192}, {4, 1, 23, 53864}, {0, 2, 11, 53840}, {8, 1, 31, 54568}, {0, 2, 18, 46400}, {0, 2, 7, 46752}, {6, 1, 28, 38608}, {0, 2, 16, 38320}, {0, 2, 5, 18864},
                {4, 1, 25, 42168}, {0, 2, 13, 42160}, {10, 2, 2, 45656}, {0, 2, 20, 27216}, {0, 2, 9, 27968}, {6, 1, 29, 44448}, {0, 2, 17, 43872}, {0, 2, 6, 38256}, {5, 1, 27, 18808}, {0, 2, 15, 18800}, {0, 2, 4, 25776}, {3, 1, 23, 27216}, {0, 2, 10, 59984}, {8, 1, 31, 27432}, {0, 2, 19, 23232}, {0, 2, 7, 43872}, {5, 1, 28, 37736}, {0, 2, 16, 37600}, {0, 2, 5, 51552}, {4, 1, 24, 54440}, {0, 2, 12, 54432}, {0, 2, 1, 55888}, {2, 1, 22, 23208},
                {0, 2, 9, 22176}, {7, 1, 29, 43736}, {0, 2, 18, 9680}, {0, 2, 7, 37584}, {5, 1, 26, 51544}, {0, 2, 14, 43344}, {0, 2, 3, 46240}, {4, 1, 23, 46416}, {0, 2, 10, 44368}, {9, 1, 31, 21928}, {0, 2, 19, 19360}, {0, 2, 8, 42416}, {6, 1, 28, 21176}, {0, 2, 16, 21168}, {0, 2, 5, 43312}, {4, 1, 25, 29864}, {0, 2, 12, 27296}, {0, 2, 1, 44368}, {2, 1, 22, 19880}, {0, 2, 10, 19296}, {6, 1, 29, 42352}, {0, 2, 17, 42208}, {0, 2, 6, 53856},
                {5, 1, 26, 59696}, {0, 2, 13, 54576}, {0, 2, 3, 23200}, {3, 1, 23, 27472}, {0, 2, 11, 38608}, {11, 1, 31, 19176}, {0, 2, 19, 19152}, {0, 2, 8, 42192}, {6, 1, 28, 53848}, {0, 2, 15, 53840}, {0, 2, 4, 54560}, {5, 1, 24, 55968}, {0, 2, 12, 46496}, {0, 2, 1, 22224}, {2, 1, 22, 19160}, {0, 2, 10, 18864}, {7, 1, 30, 42168}, {0, 2, 17, 42160}, {0, 2, 6, 43600}, {5, 1, 26, 46376}, {0, 2, 14, 27936}, {0, 2, 2, 44448}, {3, 1, 23, 21936},
                {0, 2, 11, 37744}, {8, 2, 1, 18808}, {0, 2, 19, 18800}, {0, 2, 8, 25776}, {6, 1, 28, 27216}, {0, 2, 15, 59984}, {0, 2, 4, 27424}, {4, 1, 24, 43872}, {0, 2, 12, 43744}, {0, 2, 2, 37600}, {3, 1, 21, 51568}, {0, 2, 9, 51552}, {7, 1, 29, 54440}, {0, 2, 17, 54432}, {0, 2, 5, 55888}, {5, 1, 26, 23208}, {0, 2, 14, 22176}, {0, 2, 3, 42704}, {4, 1, 23, 21224}, {0, 2, 11, 21200}, {8, 1, 31, 43352}, {0, 2, 19, 43344}, {0, 2, 7, 46240},
                {6, 1, 27, 46416}, {0, 2, 15, 44368}, {0, 2, 5, 21920}, {4, 1, 24, 42448}, {0, 2, 12, 42416}, {0, 2, 2, 21168}, {3, 1, 22, 43320}, {0, 2, 9, 26928}, {7, 1, 29, 29336}, {0, 2, 17, 27296}, {0, 2, 6, 44368}, {5, 1, 26, 19880}, {0, 2, 14, 19296}, {0, 2, 3, 42352}, {4, 1, 24, 21104}, {0, 2, 10, 53856}, {8, 1, 30, 59696}, {0, 2, 18, 54560}, {0, 2, 7, 55968}, {6, 1, 27, 27472}, {0, 2, 15, 22224}, {0, 2, 5, 19168}, {4, 1, 25, 42216},
                {0, 2, 12, 42192}, {0, 2, 1, 53584}, {2, 1, 21, 55592}, {0, 2, 9, 54560}};

        /**
         * 月份
         */
        public final static String[] MONTH_CN = new String[]{"正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月"};

        /**
         * 干
         */
        public final static String[] GAN = new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};

        /**
         * 支
         */
        public final static String[] ZHI = new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

        /**
         * 生肖
         */
        public final static String[] ANIMALS = new String[]{"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};

        /**
         * 阳历
         */
        protected String solar;

        /**
         * 农历日期
         */
        protected String lunar;

        /**
         * 农历生肖
         */
        protected String lunarAnimal;

        /**
         * 农历干支纪年
         */
        protected String lunarYearName;

        /**
         * 农历月份
         */
        protected String lunarMonth;

        /**
         * 农历天
         */
        protected String lunarDay;

        /**
         * 获取农历干支纪年
         *
         * @param year 农历年
         * @return
         */
        public static String getYearName(int year) {
            int num = year - 1900 + 36;
            return GAN[num % 10] + ZHI[num % 12] + "年";
        }

        /**
         * 获取农历生肖
         *
         * @param year 农历年
         * @return
         */
        public static String getAnimal(int year) {
            return ANIMALS[(year - 4) % 12];
        }

        /**
         * 获取闰月
         *
         * @param year 农历年
         * @return
         */
        public static int getLeapMonth(int year) {
            return getYearData(year)[0];
        }

        /**
         * 获取农历中文月份
         *
         * @param month  月
         * @param isLeap 是否为闰月
         * @return
         */
        public static String getChineseMonth(int month, boolean isLeap) {
            return isLeap ? "闰" + MONTH_CN[month - 1] : MONTH_CN[month - 1];
        }

        /**
         * 获取农历中文天数
         *
         * @param day 天
         * @return
         */
        public static String getChineseDay(int day) {
            String a = "";
            if (day == 10) {
                return "初十";
            }
            if (day == 20) {
                return "二十";
            }
            if (day == 30) {
                return "三十";
            }
            int two = (int) ((day) / 10);
            if (two == 0) {
                a = "初";
            }
            if (two == 1) {
                a = "十";
            }
            if (two == 2) {
                a = "廿";

            }
            if (two == 3) {
                a = "三";
            }

            int one = (int) (day % 10);
            switch (one) {
                case 1:
                    a += "一";
                    break;
                case 2:
                    a += "二";
                    break;
                case 3:
                    a += "三";
                    break;
                case 4:
                    a += "四";
                    break;
                case 5:
                    a += "五";
                    break;
                case 6:
                    a += "六";
                    break;
                case 7:
                    a += "七";
                    break;
                case 8:
                    a += "八";
                    break;
                case 9:
                    a += "九";
                    break;
            }
            return a;
        }

//        /**
//         * 获取农历年月份
//         *
//         * @param year 农历年
//         * @return
//         */
//        public static int[] getLunarYearMonths(int year) {
//            int[] yearData = getYearData(year);
//            int[] monthData = getMonthData(year);
//            int length = (yearData[0] == 0 ? 12 : 13);
//            int temp = 0;
//            int[] res = new int[length];
//
//            for (int i = 0; i < length; i++) {
//                temp = 0;
//                for (int j = 0; j <= i; j++) {
//                    temp += monthData[j];
//                }
//                res[i] = temp;
//            }
//
//            return res;
//        }

        /**
         * 获取农历年信息
         *
         * @param year 农历年
         * @return
         */
        public static int[] getYearData(int year) {
            return LUNAR_INFO[year - MIN_YEAR];
        }

//        /**
//         * 获取农历年月份信息
//         *
//         * @param year 农历年
//         * @return
//         */
//        public static int[] getMonthData(int year) {
//            int[] yearData = getYearData(year);
//            String bitStr = Integer.toBinaryString(yearData[3]);
//
//            for (int i = 0, j = 16 - bitStr.length(); i < j; i++) {
//                bitStr = "0" + bitStr;
//            }
//
//            char[] bitArray = bitStr.substring(0, (yearData[0] == 0 ? 12 : 13)).toCharArray();
//            int[] arr = new int[bitArray.length];
//            for (int i = 0; i < bitArray.length; i++) {
//                arr[i] = MathUtils.getInt(bitArray[i]) + 29;
//            }
//
//            return arr;
//        }

//        /**
//         * 获取农历每年的天数
//         *
//         * @param year 农历年
//         */
//        public static int getLunarYearDays(int year) {
//            int[] monthData = getLunarYearMonths(year);
//            int length = monthData.length;
//            return (monthData[length - 1] == 0 ? monthData[length - 2] : monthData[length - 1]);
//        }

//        /**
//         * 创建农阳历对象
//         *
//         * @param date      日期
//         * @param isToLunar 是否转换成农历，true：date为阳历；false：date为农历
//         * @return
//         */
//        public static Lunar create(String date, boolean isToLunar) {
//            if (isToLunar) {
//                return solarToLunar(date);
//            } else {
//                return lunarToSolar(date);
//            }
//        }

//        /**
//         * 阳历转农历
//         *
//         * @param solar 阳历，格式yyyy-MM-dd
//         */
//        public static Lunar solarToLunar(String solar) {
//            Calendar calendar = getCalendar(solar);
//            return solarToLunar(getYear(calendar), getMonth(calendar), getDay(calendar));
//        }


//        /**
//         * 阳历转农历
//         *
//         * @param year  阳历年
//         * @param month 阳历月
//         * @param day   阳历日
//         * @return
//         */
//        public static Lunar solarToLunar(int year, int month, int day) {
//            Lunar lunar = new Lunar();
//            lunar.setSolar(DateUtils.getDateStr(year, month, day));
//
//            if (year == MIN_YEAR && month <= 2 && day <= 9) {
//                lunar.setLunar(DateUtils.getDateStr(MIN_YEAR, 1, 1));
//                lunar.setLunarAnimal("兔");
//                lunar.setLunarYearName("辛卯年");
//                lunar.setLunarMonth("正月");
//                lunar.setLunarDay("初一");
//            } else {
//                int[] yearData = getYearData(year);
//                int between = DateUtils.daysBetween(DateUtils.getDate(year, yearData[1], yearData[2]), DateUtils.getDate(lunar.getSolar()));
//
//                if (between == 0) {
//                    lunar.setLunar(DateUtils.getDateStr(year, 1, 1));
//                    lunar.setLunarMonth("正月");
//                    lunar.setLunarDay("初一");
//                } else {
//                    year = between > 0 ? year : (year - 1);
//                    between = between > 0 ? between : (getLunarYearDays(year) + between);
//                    month = 0;
//                    day = 0;
//
//                    int[] yearMonth = getLunarYearMonths(year);
//                    int leapMonth = getLeapMonth(year);
//
//                    for (int i = 0; i < 13; i++) {
//                        if (between == yearMonth[i]) {
//                            month = i + 2;
//                            day = 1;
//                            break;
//                        } else if (between < yearMonth[i]) {
//                            month = i + 1;
//                            day = between + 1 - (i == 0 ? 0 : yearMonth[i - 1]);
//                            break;
//                        }
//                    }
//
//                    boolean isLeap = (leapMonth != 0 && month == leapMonth + 1);
//
//                    lunar.setLunar(DateUtils.getDateStr(year, month, day));
//                    lunar.setLunarMonth(getChineseMonth(isLeap ? (month - 1) : ((leapMonth != 0 && leapMonth + 1 < month ? (month - 1) : month)), isLeap));
//                    lunar.setLunarDay(getChineseDay(day));
//                }
//
//                lunar.setLunarAnimal(getAnimal(year));
//                lunar.setLunarYearName(getYearName(year));
//            }
//
//            return lunar;
//        }
//
//        /**
//         * 农历转阳历
//         *
//         * @param lunar 农历
//         * @return
//         */
//        public static Lunar lunarToSolar(String lunar) {
//            String[] date = lunar.split("-");
//            return lunarToSolar(MathUtils.getInt(date[0]), MathUtils.getInt(date[1]), MathUtils.getInt(date[2]));
//        }

//        /**
//         * 农历转阳历
//         *
//         * @param year  农历年
//         * @param month 农历月
//         * @param day   农历日
//         * @return
//         */
//        public static Lunar lunarToSolar(int year, int month, int day) {
//            int[] yearData = getYearData(year);
//
//            int[] monthData = getMonthData(year);
//            int between = 0;
//            for (int i = 1; i < month; i++) {
//                between += monthData[i - 1];
//            }
//            between += day - 1;
//
//            return solarToLunar(DateUtils.getDate(DateUtils.goDay(DateUtils.getDate(year, yearData[1], yearData[2]), between)));
//        }

//        /**
//         * 创建农历年
//         *
//         * @param minYear 最小农历年份，若为空，默认1891年
//         * @param maxYear 最大农历年份，若为空，默认2100年
//         * @return
//         */
//        public static List<Map<String, Object>> createLunerYear(Integer minYear, Integer maxYear) {
//            if (minYear == null) {
//                minYear = MIN_YEAR;
//            }
//            if (maxYear == null) {
//                maxYear = MAX_YEAR;
//            }
//
//            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//            Map<String, Object> map = null;
//            for (int i = minYear; i <= maxYear; i++) {
//                map = new HashMap<String, Object>();
//                map.put("id", i);
//                map.put("name", getYearName(i));
//                map.put("list", createLunarMonth(i));
//                result.add(map);
//            }
//
//            return result;
//        }

//        /**
//         * 创建农历月
//         *
//         * @param year 农历年
//         * @return
//         */
//        public static List<Map<String, Object>> createLunarMonth(int year) {
//            int leapMonth = getLeapMonth(year);
//
//            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//            Map<String, Object> map = null;
//            for (int i = 1, j = 1; i < 13; i++, j++) {
//                map = new HashMap<String, Object>();
//                map.put("id", j);
//                map.put("name", getChineseMonth(i, false));
//                map.put("list", createLunarDay(year, j));
//                result.add(map);
//
//                if (leapMonth != 0 && i == leapMonth) {
//                    map = new HashMap<String, Object>();
//                    map.put("id", ++j);
//                    map.put("name", getChineseMonth(i, true));
//                    map.put("list", createLunarDay(year, j));
//                    result.add(map);
//                }
//            }
//
//            return result;
//        }
//
//        /**
//         * 创建农历日
//         *
//         * @param year  农历年
//         * @param month 农历月
//         * @return
//         */
//        public static List<Map<String, Object>> createLunarDay(int year, int month) {
//            int[] monthData = getMonthData(year);
//            int days = monthData[month - 1];
//
//            List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//            Map<String, Object> map = null;
//            for (int i = 1; i <= days; i++) {
//                map = new HashMap<String, Object>();
//                map.put("id", i);
//                map.put("name", getChineseDay(i));
//                result.add(map);
//            }
//
//            return result;
//        }

        public String getSolar() {
            return solar;
        }

        public void setSolar(String solar) {
            this.solar = solar;
        }

        public String getLunar() {
            return lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }

        public String getLunarAnimal() {
            return lunarAnimal;
        }

        public void setLunarAnimal(String lunarAnimal) {
            this.lunarAnimal = lunarAnimal;
        }

        public String getLunarYearName() {
            return lunarYearName;
        }

        public void setLunarYearName(String lunarYearName) {
            this.lunarYearName = lunarYearName;
        }

        public String getLunarMonth() {
            return lunarMonth;
        }

        public void setLunarMonth(String lunarMonth) {
            this.lunarMonth = lunarMonth;
        }

        public String getLunarDay() {
            return lunarDay;
        }

        public void setLunarDay(String lunarDay) {
            this.lunarDay = lunarDay;
        }

    }


    /**
     * 根据日期获取星期几
     *
     * @param date
     * @return
     */
    public static String getWeekday(Date date) {
        int day = DateUtils.getCalendar(date).get(Calendar.DAY_OF_WEEK);
        String dayOfWeek = "";
        switch (day) {
            case 1:
                dayOfWeek = "星期日";
                break;
            case 2:
                dayOfWeek = "星期一";
                break;
            case 3:
                dayOfWeek = "星期二";
                break;
            case 4:
                dayOfWeek = "星期三";
                break;
            case 5:
                dayOfWeek = "星期四";
                break;
            case 6:
                dayOfWeek = "星期五";
                break;
            case 7:
                dayOfWeek = "星期六";
                break;
            default:
                throw new RuntimeException("未知日期时间点");
        }
        return dayOfWeek;
    }

    /**
     * 获得本月第一天0点时间
     *
     * @return
     */
    public static Date getTimesMonthMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获得本月最后一天24点时间
     *
     * @return
     */
    public static Date getTimesMonthNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    /**
     * 计算当前时间是否在开始时间和结束时间范围内
     *
     * @param startTime 开始时间(格式:HH:mm:ss，如:08:00)
     * @param endTime 结束时间(格式:HH:mm:ss，如:20:00)
     *
     * @return boolean 在时间范围内返回true
     */
    public static boolean isWorkTime(String startTime,String endTime) {
        boolean flag = false;
            Date now = DateUtils.getDate(DateUtils.getDate(new Date(), DateUtils.TIME_FORMAT), DateUtils.TIME_FORMAT);
            Date morning = DateUtils.getDate(startTime, DateUtils.TIME_FORMAT);
            Date night = DateUtils.getDate(endTime, DateUtils.TIME_FORMAT);
            //在时间范围内返回true
            if (now.before(night) && now.after(morning)) {
                flag = true;
            }
        return flag;
    }

//    /**
//     * 获取开始月份与结束月份区间列表
//     *
//     * @param startMonth 开始月份
//     * @param endMonth 结束月份
//     *
//     * @return Set 月份列表
//     */
//    public static Set getMonthList(Integer startMonth, Integer endMonth) {
//        startMonth = CheckUtils.isEmpty(startMonth) ? 1 : startMonth;
//        endMonth = CheckUtils.isEmpty(endMonth) ? 12 : endMonth;
//        Set<Integer> months = new TreeSet<>();
//        for (int i = startMonth; i <= endMonth; i++) {
//            months.add(i);
//        }
//        return months;
//    }
}
