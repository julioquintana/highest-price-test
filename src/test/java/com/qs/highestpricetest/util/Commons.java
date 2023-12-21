package com.qs.highestpricetest.util;

import java.time.format.DateTimeFormatter;

public class Commons {
    private static final String format = "yyyy-MM-dd-HH.mm.ss";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

}
