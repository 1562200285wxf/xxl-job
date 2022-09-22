package com.xxl.job.executor.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-22 10:54
 * @description：
 */
public class DateUtils {


    public static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
            "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        if (date == null) {
            return "";
        }

        String formatDate;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 指定格式时间字符串转换为日期类型
     *
     * @param dateStr 时间字符串
     * @param pattern 日期格式
     * @return 转换后的日期
     */
    public static Date strToDate(String dateStr, String pattern) {
        if (Objects.isNull(dateStr)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);// 小写的mm表示的是分钟

        Date date;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            date = null;
        }

        return date;
    }


    /**
     * 得到指定日期的0时
     */
    public static Date getYYYYMMDD000000(Date date) {
        return strToDate(formatDate(date, parsePatterns[0]) + " 00:00:00", parsePatterns[1]);
    }

    /**
     * 得到指定日期的24时
     */
    public static Date getYYYYMMDD235959(Date date) {
        return strToDate(formatDate(date, parsePatterns[0]) + " 23:59:59", parsePatterns[1]);
    }

    /**
     * 获取指定日期的前一天
     */
    public static Date getDayBefore(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        Date result = c.getTime();
        return result;
    }
}
