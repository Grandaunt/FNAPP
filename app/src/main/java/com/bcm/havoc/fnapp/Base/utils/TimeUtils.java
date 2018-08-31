package com.bcm.havoc.fnapp.Base.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by TAO_SX on 2016/4/10/010.
 */
public class TimeUtils {
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE    = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_DATE_NOT_0    = new SimpleDateFormat("yyyy-M-d");
    private static Calendar calendar;

    private TimeUtils() {
        throw new AssertionError();
    }

    /**
     * long time to string
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }
    public static String getToday() {
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate =  new Date(System.currentTimeMillis());
        String str   =   formatter.format(curDate);
        return str;
    }
    public static String getEndday() {
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate =  new Date(System.currentTimeMillis());

        Calendar calendar   =   new GregorianCalendar();
        calendar.setTime(curDate);
//        calendar.add(calendar.YEAR, 1);//把日期往后增加一年.整数往后推,负数往前移动
//        calendar.add(calendar.DAY_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
        calendar.add(calendar.DATE,5);//把日期往后增加一天.整数往后推,负数往前移动
//        calendar.add(calendar.WEEK_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
        curDate=calendar.getTime();   //这个时间就是日期往后推一天的结果
//        System.out.println(date.toString());


        String str   =   formatter.format(curDate);
        return str;
    }

    public static Calendar getDate() {
        // Calendar 取得当前时间的方法
        // 初始化 (重置) Calendar 对象
        calendar = Calendar.getInstance();
        // 或者用 Date 来初始化 Calendar 对象
        calendar.setTime(new Date());
        return calendar;
    }


    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }

    /**
     * 只到年月
     * @param date
     * @return
     */
    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date);
    }

    public static String GetTimeNot0(String string) {
        Date currentTime = new Date(string);//得到当前时间
        return DATE_FORMAT_DATE_NOT_0.format(currentTime); //将日期时间格式化
    }
}
