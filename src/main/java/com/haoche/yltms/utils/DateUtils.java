package com.haoche.yltms.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtils {
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int a = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        int b = (int) ((date2.getTime() - date1.getTime()) % (1000*3600*24));
        if(b>0){
            return a + 1;
        }
        return a;
    }

    // 获取上周的开始时间
    public static Date getBeginDayOfLastWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek - 7);
        return getDayStartTime(cal.getTime());
    }

    // 获取上周的结束时间
    public static Date getEndDayOfLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfLastWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    // 获取某个日期的开始时间
    public static Date getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = new Date(calendar.getTimeInMillis());
        return date;
    }

    // 获取某个日期的结束时间
    public static Date getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Date(calendar.getTimeInMillis());
    }


    public static void main(String[] args)
    {
        System.out.println(getBeginDayOfLastWeek());
        System.out.println(getEndDayOfLastWeek());
    }
}
