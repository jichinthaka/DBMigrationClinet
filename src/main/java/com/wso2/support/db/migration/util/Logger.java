package com.wso2.support.db.migration.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
        public static void error(String str)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime localDateTime = LocalDateTime.now();
            String formattedDateTime = localDateTime.format(formatter);
            System.out.println(ANSI_RED + "[" + formattedDateTime + "] - " + " ERROR  - " + str + ANSI_RESET);
        }

        public static void info(String str)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime localDateTime = LocalDateTime.now();
            String formattedDateTime = localDateTime.format(formatter);
            System.out.println("[" + formattedDateTime + "] - " + " INFO - " + str);
        }
}
