package com.assignment.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static int parseTabTitle(String parseStr) {
        String count = parseStr.substring(parseStr.indexOf('(') + 1, parseStr.indexOf(')'));
        return Integer.parseInt(count);
    }

    public static String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }
}
