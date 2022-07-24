package com.assignment.utils;

public class Utils {

    public static int parseTabTitle(String parseStr) {
        String count = parseStr.substring(parseStr.indexOf('(') + 1, parseStr.indexOf(')'));
        return Integer.parseInt(count);
    }
}
