package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    /**
     * Chuyển đổi String sang Date
     * @param date là String cần chuyển
     * @param pattern là định dạng thời gian
     * @return Date kết quả
     */
    public static Date toDate(String stringDate, String pattern) {
        try {
            Date date = new SimpleDateFormat(pattern).parse(stringDate);
            return date;
        } 
        catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Chuyển đổi từ Date sang String
     * @param date là Date cần chuyển đổi
     * @param pattern là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String pattern) {
        String stringDate = new SimpleDateFormat(pattern).format(date);
        return stringDate;
    }

    /**
     * Bổ sung số ngày vào thời gian
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung váo date
     * @return Date kết quả
     */
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
}
