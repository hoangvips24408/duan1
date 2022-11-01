package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class XDate {
    static SimpleDateFormat format = new SimpleDateFormat();
    public static Date toDAte(String date,String pattern){
        try {
            format.applyPattern(pattern);
            return format.parse(date);
        } catch (Exception e) {
        }
        return null;
    }
    public static String toString(Date date,String pattern){
        format.applyPattern(pattern);
        return format.format(date);
    }
    public static Date addDays(Date date, long days){
        date.setTime(date.getTime()+days*24*60*60*1000);
        return date;
    }
    
}
