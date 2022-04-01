package com.fc.advice;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class CustomDateFormatter implements Formatter<Date> {
    String pattern="yyyy/MM/dd";
    @Override
    //将字符串转成Date类型
    public Date parse(String s, Locale locale) throws ParseException {

        if (s.contains("-")){
            pattern ="yyyy-MM-dd";
        }
        return new SimpleDateFormat(pattern,locale).parse(s);
    }

    @Override
    //将Date转为字符串
    public String print(Date date, Locale locale) {

        return new SimpleDateFormat(pattern,locale).format(date);
    }
}
