package com.accompnay.seftest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test4 {
    public static void main(String[] args) throws ParseException {
        String pattern = "yyyy-MM-dd'T'HH:mm:ssXXX";
        SimpleDateFormat sf = new SimpleDateFormat(pattern);

        Date parse = sf.parse("2020-07-10T08:36:00-07:00");
        System.out.println(sf.format(parse));
    }

}
