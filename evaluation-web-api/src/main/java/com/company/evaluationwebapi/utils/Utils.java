package com.company.evaluationwebapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.company.evaluationwebapi.constans.Constans;

public class Utils {

    public static Date parseStringToDate (String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constans.DATE_FORMAT);
        return simpleDateFormat.parse(dateString);
    }

    public static String parseDateToString (Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constans.DATE_FORMAT);
        return simpleDateFormat.format(date);
    }
}
