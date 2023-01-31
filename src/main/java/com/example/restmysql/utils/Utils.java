package com.example.restmysql.utils;

public class Utils {

    public static String secondsToTimeFormat(Double totalSeconds) {
        int hours = totalSeconds.intValue() / 3600;
        int minutes = (totalSeconds.intValue() % 3600) / 60;

        if (hours == 0) return String.format("%d min", minutes);
        if (hours != 0 && minutes == 0) return String.format("%d h", hours);

        return String.format("%d h %d min", hours, minutes);
    }
}