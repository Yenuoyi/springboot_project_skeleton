package com.example.skeleton.common.util;


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yebing
 */
public class DateUtils {
    public static final String YMD = "yyyyMMdd";
    public static final String YYDDMMHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_SLASH = "yyyy/MM/dd";
    public static final String YMD_DASH = "yyyy-MM-dd";
    public static final String YMD_DASH_WITH_TIME = "yyyy-MM-dd H:m";
    public static final String YDM_SLASH = "yyyy/dd/MM";
    public static final String YDM_DASH = "yyyy-dd-MM";
    public static final String HM = "HHmm";
    public static final String HM_COLON = "HH:mm";
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final long DAY = 24 * 60 * 60 * 1000L;

    private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();

    private DateUtils() {
    }

    public static DateFormat getFormat(String pattern) {
        DateFormat format = DFS.get(pattern);
        if (format == null) {
            format = new SimpleDateFormat(pattern);
            DFS.put(pattern, format);
        }
        return format;
    }

    public static Date parse(String source, String pattern) {
        if (source == null) {
            return null;
        }
        Date date;
        try {
            date = getFormat(pattern).parse(source);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return getFormat(pattern).format(date);
    }

    private static Calendar convert(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 返回指定天数位移后的日期
     */
    public static Date dayOffset(Date date, int offset) {
        return offsetDate(date, Calendar.DATE, offset);
    }

    /**
     * 返回指定日期相应位移后的日期
     *
     * @param date   参考日期
     * @param field  位移单位，见 {@link Calendar}
     * @param offset 位移数量，正数表示之后的时间，负数表示之前的时间
     * @return 位移后的日期
     */
    public static Date offsetDate(Date date, int field, int offset) {
        Calendar calendar = convert(date);
        calendar.add(field, offset);
        return calendar.getTime();
    }

    /**
     * 返回两个日期间的差异天数
     *
     * @param date1 参照日期
     * @param date2 比较日期
     * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
     */
    public static int dayDiff(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        return (int) (diff / DAY);
    }

    public static String getCurrentDate(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            return format(new Date(), YYDDMMHHMMSS);
        }
        return format(new Date(), pattern);
    }

    public static String getDateStr(Date date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            return format(date, YYDDMMHHMMSS);
        }
        return format(date, pattern);
    }

    public static Date parseReturnTime(String date, String pattern) {
        if (date == null) {
            return new Date();
        } else {
            return parse(date, pattern);
        }
    }

    /**
     * 当期日期加一小时
     */
    public static Date addHours(Date times) {
        Calendar c = Calendar.getInstance();
        c.setTime(times); // 设置当前日期
        c.add(Calendar.HOUR, 1); // 日期分钟加1,Calendar.DATE(天),Calendar.HOUR(小时)
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date date = c.getTime(); // 结果
        return date;
    }
}