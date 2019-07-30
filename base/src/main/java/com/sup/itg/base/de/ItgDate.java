package com.sup.itg.base.de;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ItgDate {

    public static String getToday() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss", Locale.CHINA);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String getToday(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
