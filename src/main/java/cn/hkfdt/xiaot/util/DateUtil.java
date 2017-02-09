package cn.hkfdt.xiaot.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
    public static String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static String STANDARD_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static long string2Long(String time) throws ParseException {
        SimpleDateFormat default_format = new SimpleDateFormat(STANDARD_DATE_TIME_PATTERN);
        //sb.deleteCharAt(time.lastIndexOf(':'));
        Date date = default_format.parse(time);
        return date.getTime();
    }

    public static int getDaysofMonth(int year, int month) {
        int days = 0;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (isLeapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                days = 31;
                break;
        }

        return days;
    }


    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }

    public static String getCurrentDate(String type) {
        SimpleDateFormat format = new SimpleDateFormat(type);
        return format.format(new Date());
    }

    public static long String2Long(String time, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = format.parse(time);
        return date.getTime();
    }

    public static String long2String(long time) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN);
        StringBuilder date = new StringBuilder(format.format(new Date(time)));
        date.insert(date.length() - 2, ':');
        return date.toString();
    }

    public static long sring2Long(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN);
        StringBuilder sb = new StringBuilder();
        sb.append(time);
        sb.deleteCharAt(time.length() - 3);
        Date date = format.parse(sb.toString());
        return date.getTime();
    }

    public static long standStr2Long(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
        Date date = format.parse(time);
        return date.getTime();
    }

    public static long standStr2Long(String time, String f) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(f);
        Date date = format.parse(time);
        return date.getTime();
    }

    public static String long2StandStr(long time) {
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_DATE_TIME_PATTERN);
        return format.format(new Date(time));
    }

    public static String long2StandStr(String dateFormat, long time) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(new Date(time));
    }


    public static Date getCST(String strGMT) throws ParseException {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        return df.parse(strGMT);
    }

    public static Date getDate(String strGMT) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        return df.parse(strGMT);
    }

    public static long getCSTLong(String strGMT) throws ParseException {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        Date d = df.parse(strGMT);
        return d.getTime();
    }

    public static long getGMTLong(String strGMT) throws ParseException {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        Date d = df.parse(strGMT);
        return d.getTime();
    }

    public static long getLong(String pattern, String strGMT) throws ParseException {
        DateFormat df = new SimpleDateFormat(pattern, Locale.ENGLISH);
        Date d = df.parse(strGMT);
        return d.getTime();
    }

    public static String getGMT(long longCST) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT")); // modify Time Zone.

        return (df.format(new Date(longCST)));
    }

    public static String getGMT(Date dateCST) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT")); // modify Time Zone.
        return (df.format(dateCST));
    }

    public static boolean isSameMonth(long date1, long date2) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date1);
        int month1 = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        c.setTimeInMillis(date2);
        int month2 = c.get(Calendar.MONTH);
        int year2 = c.get(Calendar.YEAR);
        return (month1 == month2) && (year == year2);
    }

    public static boolean isYesterday(long time) {
        long now = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        int day = c.get(Calendar.DAY_OF_YEAR);
        int year = c.get(Calendar.YEAR);

        Calendar n = Calendar.getInstance();
        n.setTimeInMillis(now);
        int daynow = n.get(Calendar.DAY_OF_YEAR);
        int yearnow = n.get(Calendar.YEAR);
        return yearnow == year && (daynow - day) == 1;
    }

    public static long getTodayBeginMSecond() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);
        return cal.getTimeInMillis();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtil.string2Long("2016-01-01 00:01:00"));
    }




}
