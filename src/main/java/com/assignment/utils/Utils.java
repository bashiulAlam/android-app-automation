package com.assignment.utils;

public class Utils {

    public static int parseTabTitle(String title) {
        String count = title.substring(title.indexOf('(') + 1, title.indexOf(')'));
        return Integer.parseInt(count);
    }
}
