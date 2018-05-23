package com.test.qa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SomeUsefulMethods {
    public static String getCurrentTime() {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd_kk-mm-ss", Locale.ENGLISH);
        return format1.format(d);
    }
}
