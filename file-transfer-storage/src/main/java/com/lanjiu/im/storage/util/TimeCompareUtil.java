package com.lanjiu.im.storage.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TimeCompareUtil {

    public long getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    public Date sqlDateToUtilDate(java.sql.Date date){
        System.out.println("sqlDate : " + date);
        Timestamp sqlDate = new Timestamp(date.getTime());//uilt date转sql date
        Date utilDate = new Date(sqlDate.getTime());
        System.out.println("utilDate : " + sqlDate);
        return utilDate;
    }

    public java.sql.Date sqlDateToUtilDate(Date date){
        System.out.println("utilDate : " + date);
        Timestamp sqlDate = new Timestamp(date.getTime());//uilt date转sql date
        System.out.println("sqlDate : " + sqlDate);
        java.sql.Date sqlDate2 = new java.sql.Date(sqlDate.getTime());
        return sqlDate2;
    }
}
